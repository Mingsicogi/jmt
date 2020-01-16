package my.mins.jmt.app.send.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveLineMessage {

    @Autowired
    private LineBotChatRepository lineBotChatRepository;

}
