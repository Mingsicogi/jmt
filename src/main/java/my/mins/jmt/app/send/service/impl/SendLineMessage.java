package my.mins.jmt.app.send.service.impl;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.response.BotApiResponse;
import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.send.dto.MessageDTO;
import my.mins.jmt.app.send.service.SendMessage;
import my.mins.jmt.app.send.vo.MessageCommonVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * line bot을 사용해서 메세지 전송
 *
 * @author minssogi
 */
@Service
@Slf4j
public class SendLineMessage implements SendMessage {

	@Value("${line.bot.channel-token}")
	private String secretToken;

	@Override
	public <T extends MessageCommonVO> boolean send(T message) {
		LineMessagingClient client = LineMessagingClient.builder(secretToken).build();

		PushMessage pushMessage = null;

		// 일반 텍스트 문자 전송
		if (message instanceof MessageDTO.Plain) {
			pushMessage = new PushMessage(message.getTo(), new TextMessage((String)message.getMessage()));
		}

		// flex type의 문자 발송
		else if (message instanceof MessageDTO.Flex) {
			pushMessage = new PushMessage(message.getTo(), (FlexMessage)message.getMessage());
		}

		// bubble type의 문자 발송
		else {
			pushMessage = new PushMessage(message.getTo(), new FlexMessage(((MessageDTO.Bubble)message).getAltText(), (Bubble)message.getMessage()));
		}


		BotApiResponse botApiResponse;

		try {
			botApiResponse = client.pushMessage(pushMessage).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return false;
		}

		log.info("{}", botApiResponse);
		return true;
	}
}
