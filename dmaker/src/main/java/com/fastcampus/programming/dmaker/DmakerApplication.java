package com.fastcampus.programming.dmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // @CreateDate @LastmodifiedDate 자동으로 값을 세팅해준다.
public class DmakerApplication {

	public static void main(String[] args) {

		SpringApplication.run(DmakerApplication.class, args);
	}

}
