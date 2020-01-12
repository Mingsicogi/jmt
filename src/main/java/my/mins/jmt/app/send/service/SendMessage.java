package my.mins.jmt.app.send.service;

import my.mins.jmt.app.send.dto.MessageDTO;

public interface SendMessage {

	boolean send(MessageDTO message);
}
