package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController //RestController라는 타입의 빈으로
                //Controller와 ResponseBody를 합한것.
@Slf4j
@RequiredArgsConstructor
public class DMakerController {

    private final DMakerService dMakerService;
    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow","Elsa","Olaf");
    }

    @GetMapping("/create-developers")
    public List<String> createDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /create-developers HTTP/1.1");

        dMakerService.createDeveloper();

        return Collections.singletonList("Olaf");
    }
}
