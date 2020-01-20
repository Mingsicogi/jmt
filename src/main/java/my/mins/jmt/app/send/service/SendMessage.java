package my.mins.jmt.app.send.service;

import my.mins.jmt.app.send.vo.MessageCommonVO;

public interface SendMessage {

	<T extends MessageCommonVO> boolean send(T message);
}
