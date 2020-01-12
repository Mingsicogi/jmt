package my.mins.jmt.app.send.service.impl;

import my.mins.jmt.app.send.dto.MessageDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SendLineMessageTest {

    @Autowired
    private SendLineMessage sendLineMessage;

    @Test
    public void send() {
        MessageDTO message = new MessageDTO();

        message.setMessages("징아 뭐먹을라고오??!!!!");
        message.setTo("Cc8132e37b4f6d7eb457858802d3d9f45");

        Assert.assertTrue(sendLineMessage.send(message));
    }
}