package fr.loicpincon.jaccuzispa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JaccuziSpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaccuziSpaApplication.class, args);
	}

}
