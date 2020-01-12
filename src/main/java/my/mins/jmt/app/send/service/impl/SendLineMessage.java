package my.mins.jmt.app.send.service.impl;

import my.mins.jmt.app.send.cd.MessageAppCd;
import my.mins.jmt.app.send.dto.MessageDTO;
import my.mins.jmt.app.send.service.SendMessage;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * line bot을 사용해서 메세지 전송
 *
 * @author minssogi
 */
@Service
public class SendLineMessage implements SendMessage {

	@Autowired
	private RestTemplate restTemplate;

//	@Value("${line.bot.channel-token}")
//	private String secretToken;

	@Override
	public boolean send(MessageDTO message) {
		String secretToken = "82sHmRUkzBRp1CDLVm0myFkQPBvI++vVPFe6+NaCR36eobstKP1G6PnbgdnkgUTZpHsLfI4XguXlUkKyg7lumljWt2W71vvpdyjGpGZhYO/T03PSUOvLSzzVAglTiVgQIooH8W5SUV5G32E0lkBvoAdB04t89/1O/w1cDnyilFU=";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

//		byte[] encodedAuth = Base64.encodeBase64(secretToken.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + secretToken;
		headers.set("Authorization", authHeader);

		HttpEntity<MessageDTO> httpEntity = new HttpEntity<>(message, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(MessageAppCd.LINE.getPushMessageUrl(), httpEntity, String.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			return true;
		}

		return false;
	}
}
