package my.mins.jmt.common.controller;

import lombok.extern.slf4j.Slf4j;
import my.mins.jmt.app.common.annotation.DisguiseRequestParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
@Slf4j
public class SystemCheck {

    @GetMapping("/check")
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping
    @DisguiseRequestParameter
    public ResponseEntity<String> annotationCheck(String message) {
        log.info("=== 위변조 끘! ===");
        return ResponseEntity.ok(message);
    }
}