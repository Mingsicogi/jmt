package my.mins.jmt.app.send.controller;


import com.linecorp.bot.model.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/event/message")
public class ReceiveEventFromLineBot {

    /**
     * 봇이 채팅방에 들어갔을 때 발생하는 이벤트를 전달 받는 컨트롤러
     *
     * @param event
     * @return
     */
    @PostMapping("/join")
    public ResponseEntity<Event> receiveJoinEvent(@RequestBody Event event) {
        log.info("receiveJoinEvent : {}", event);
        return ResponseEntity.ok(event);
    }

    /**
     * 봇이 채팅방에 나갔을 때 발생하는 이벤트를 전달 받는 컨트롤러
     *
     * @param event
     * @return
     */
    @PostMapping("/leave")
    public ResponseEntity<Event> receiveLeaveEvent(@RequestBody Event event) {
        log.info("receiveLeaveEvent : {}", event);
        return ResponseEntity.ok(event);
    }
}
