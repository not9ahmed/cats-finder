package com.notahmed.catsfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@GetMapping("/")
	public HomeData HomePage(){
		return new HomeData(
				"Homepage",
				"Ahmed",
				LocalDateTime.now()
		);

	}

	record HomeData(
			String title,
			String CurrentUSer,
			LocalDateTime dateTime

	){}
}
