package com.fastcampus.programming.dmaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController //RestController라는 타입의 빈으로
                //Controller와 ResponseBody를 합한것.
@Slf4j
public class DMakerController {
    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow","Elsa","Olaf");
    }
}
