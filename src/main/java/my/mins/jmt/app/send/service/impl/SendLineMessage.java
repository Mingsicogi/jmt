package my.mins.jmt.app.send.service.impl;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.send.dto.MessageDTO;
import my.mins.jmt.app.send.service.SendMessage;
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
	public boolean send(MessageDTO message) {
		LineMessagingClient client = LineMessagingClient.builder(secretToken).build();

		PushMessage pushMessage = new PushMessage(message.getTo(), new TextMessage(message.getMessages()));

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
