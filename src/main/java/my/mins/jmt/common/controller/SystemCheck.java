package my.mins.jmt.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemCheck {

    @PostMapping("/check")
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("OK");
    }
}