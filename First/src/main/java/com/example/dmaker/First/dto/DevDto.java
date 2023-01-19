package com.example.dmaker.First.dto;

import java.time.LocalDateTime;

public class DevDto {
    String name;
    Integer age;
    LocalDateTime startAt;


    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public LocalDateTime getStartAt() {
        return this.startAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }
}
