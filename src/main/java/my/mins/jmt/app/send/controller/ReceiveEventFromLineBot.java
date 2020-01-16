package my.mins.jmt.app.send.controller;


import com.linecorp.bot.model.event.Event;
import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.send.entity.LineBotChat;
import my.mins.jmt.app.send.service.impl.LineBotChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Slf4j
@Controller
@RequestMapping("/event/message")
public class ReceiveEventFromLineBot {

    @Autowired
    private LineBotChatRepository lineBotChatRepository;

    /**
     * 봇이 채팅방에 들어갔을 때 발생하는 이벤트를 전달 받는 컨트롤러
     *
     * @param event
     * @return
     */
    @PostMapping("/join")
    public ResponseEntity<Event> receiveJoinEvent(@RequestBody Event event) {
        log.info("receiveJoinEvent : {}", event);

        LineBotChat dbParam = new LineBotChat();
        dbParam.setGroupId(event.getSource().getSenderId());
        dbParam.setJoinYmdt(new Date(System.currentTimeMillis()));

        try {
            lineBotChatRepository.save(dbParam);
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
    @PostMapping("/leave")
    @Transactional
    public ResponseEntity<Event> receiveLeaveEvent(@RequestBody Event event) {
        log.info("receiveLeaveEvent : {}", event);

        lineBotChatRepository.removeByGroupId(event.getSource().getSenderId());

        return ResponseEntity.ok(event);
    }
}
