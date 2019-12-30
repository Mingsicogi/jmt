package my.mins.jmt.app.send.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test/webhook")
public class WebHook {

	@RequestMapping("/minssogi")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("GOOOOOOOOOOOOOOOOOOOD");
	}
}
