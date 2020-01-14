package my.mins.jmt.app.send.controller;

import my.mins.jmt.app.send.dto.ApiDTO;
import my.mins.jmt.app.send.dto.MessageDTO;
import my.mins.jmt.app.send.service.impl.SendLineMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send/message")
public class ApiSendMessage {

	@Autowired
	private SendLineMessage sendLineMessage;

	@PostMapping("")
	public ResponseEntity<String> sendMessage(@RequestBody ApiDTO.Req req) {

		MessageDTO message = new MessageDTO();

		message.setMessages(req.getMessage());
		message.setTo("Cc8132e37b4f6d7eb457858802d3d9f45");

		return sendLineMessage.send(message) ? ResponseEntity.ok("Success") : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
