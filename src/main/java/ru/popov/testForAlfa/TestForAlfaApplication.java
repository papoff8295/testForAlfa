package ru.popov.testForAlfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TestForAlfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestForAlfaApplication.class, args);
	}

}
