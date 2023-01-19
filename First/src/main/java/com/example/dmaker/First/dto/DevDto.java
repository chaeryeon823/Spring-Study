package com.example.dmaker.First.dto;

import lombok.*;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j

public class DevDto {
    String name;
    Integer age;
    Integer experienceYear;
    LocalDateTime startAt;

    public void printLog() {
        log.info(getName());
    }

}

/*@UtilityClass
public class DebUtil {
    public static void printLog() {
        System.out.println(LocalDateTime.of(2021,7,21,2,22));
    }

    public static void printNow() {
        System.out.println(LocalDateTime.now());
    }

}
*/