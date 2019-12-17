package my.mins.jmt.common.controller;

import my.mins.jmt.common.entity.Test;
import my.mins.jmt.common.service.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemCheck {

    @Autowired
    private TestRepository testRepository;

    @PostMapping("/check")
    public ResponseEntity<String> check(){

        Test test = new Test();
        test.setAa("aaa");

        testRepository.save(test);

        return ResponseEntity.ok("OK");
    }
}