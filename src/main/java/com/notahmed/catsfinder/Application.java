package com.notahmed.catsfinder;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

// adding the props configs
//@EnableConfigurationProperties({CatFinderProperties.class, RsaKeyProperties.class})

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v0")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}




	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {

//			Inserting list of users
//			userRepository.saveAll()

			// insert data
			System.out.println("Spring Boot is running...");

		};
	}


//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository userRepository, CatRepository catRepository)  {

//
//		return args1 -> {


//			User ann = userRepository.findById(8L).orElse(null);
//
//			System.out.println(ann);
//
//			List<CatDetailsNew> catAndUser = catRepository.findCatAndComments(11L);
//
//			System.out.println("catAndUser");
//			System.out.println(catAndUser);
//
//			catAndUser.forEach(System.out::println);



//		};
//
//
//
//	}



}
