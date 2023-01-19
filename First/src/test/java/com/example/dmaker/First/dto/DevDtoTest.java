package com.example.dmaker.First.dto;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DevDtoTest {
    @Test
    void test() {
        final DevDto devDto = DevDto.builder()
                .name("snow")
                .age(21)
                .experienceYear(3)
                .startAt(LocalDateTime.now())
                .build();


        System.out.println(devDto);
        devDto.printLog();
    }


}