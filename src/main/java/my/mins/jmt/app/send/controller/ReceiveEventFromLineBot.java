package my.mins.jmt.app.send.controller;


import com.linecorp.bot.model.event.Event;
import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.send.dto.MessageDTO;
import my.mins.jmt.app.send.entity.LineBotChat;
import my.mins.jmt.app.send.service.impl.LineBotChatRepository;
import my.mins.jmt.app.send.service.impl.SendLineMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/event/message")
public class ReceiveEventFromLineBot {

    @Autowired
    private LineBotChatRepository lineBotChatRepository;

    @Autowired
    private SendLineMessage sendLineMessage;

    @Value("${line.bot.master.groupId}")
    private String masterGroupId;

    private static final String sendTargetAliasPrefix = "mins-";

    /**
     * 봇이 채팅방에 들어갔을 때 발생하는 이벤트를 전달 받는 컨트롤러
     *
     * @param event
     * @return
     */
    @Transactional
    @PostMapping("/join")
    public ResponseEntity<Event> receiveJoinEvent(@RequestBody Event event) {
        log.info("receiveJoinEvent : {}", event);


        LineBotChat dbParam = new LineBotChat();
        dbParam.setSendTargetId(event.getSource().getSenderId());
        dbParam.setSendTargetAlias(sendTargetAliasPrefix + UUID.randomUUID());
        dbParam.setJoinYmdt(new Date(System.currentTimeMillis()));

        try {
            lineBotChatRepository.save(dbParam);
            sendLineMessage.send(new MessageDTO.Plain(masterGroupId, prettyNotifyMessageContents("JOIN", dbParam)));
        } catch (DataIntegrityViolationException e) {
            log.warn("{}", e.getMessage(), e);
        }

        return ResponseEntity.ok(event);
    }

    /**
     * 봇이 채팅방에 나갔을 때 발생하는 이벤트를 전달 받는 컨트롤러
     *
     * @param event
     * @return
     */
    @Transactional
    @PostMapping("/leave")
    public ResponseEntity<Event> receiveLeaveEvent(@RequestBody Event event) {
        log.info("receiveLeaveEvent : {}", event);

        String sendTargetId = event.getSource().getSenderId();
        LineBotChat dbParam = lineBotChatRepository.findBySendTargetId(sendTargetId);


        if(dbParam != null) {
            lineBotChatRepository.removeBySendTargetId(dbParam.getSendTargetId());
            sendLineMessage.send(new MessageDTO.Plain(masterGroupId, prettyNotifyMessageContents("LEAVE", dbParam)));
        } else {
            sendLineMessage.send(new MessageDTO.Plain(masterGroupId, "mins bot이 " + sendTargetId + "에서 나갔습니다. \nDB 저장된 매핑 정보가 없어 삭제된 정보가 없습니다."));
        }



        return ResponseEntity.ok(event);
    }

    private String prettyNotifyMessageContents(String titleMessage, LineBotChat param) {
       return
           "===== " + titleMessage + " =====" + "\n" +
           "send target id : " + param.getSendTargetId() + "\n" +
           "send target alias : " + param.getSendTargetAlias() + "\n";
    }
}
