package com.notahmed.catsfinder;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// adding the props configs
// props should be registered here such as secret keys
//@EnableConfigurationProperties({CatFinderProperties.class, RsaKeyProperties.class})

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("Spring Boot is running...");

		};
	}


}
