package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController //RestController라는 타입의 빈으로
//Controller와 ResponseBody를 합한것.
@Slf4j
@RequiredArgsConstructor
@ToString
public class DMakerController {

    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return Arrays.asList("snow", "Elsa", "Olaf");
    }

    // 일반적으로 새로운 resource 만들때는 POST 사용한다.
    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            // 자바빈 Validation을 동작하게 @Valid 추가
            @Valid @RequestBody CreateDeveloper.Request request
            ) {
        log.info("request : {}",request);

        return dMakerService.createDeveloper(request);
    }
}
