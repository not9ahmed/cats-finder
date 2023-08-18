package com.notahmed.catsfinder;

import com.notahmed.catsfinder.models.Breed;
import com.notahmed.catsfinder.models.Cat;
import com.notahmed.catsfinder.models.Comment;
import com.notahmed.catsfinder.models.User;
import com.notahmed.catsfinder.repository.BreedRepository;
import com.notahmed.catsfinder.repository.CatRepository;
import com.notahmed.catsfinder.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, CatRepository catRepository, BreedRepository breedRepository)  {


//		Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse("03/33/2023");

		Date birthdate = new Date();



		return args -> {


			// remove the exisiting cat first
//			catRepository.deleteById(5L);

			// remove the existing user
//			userRepository.deleteById(14L);
//			userRepository.deleteById(16L);


			User ann = userRepository.findById(8L).orElse(null);

			System.out.println(ann);

			// Creating the user
//			AggregateReference<User, Long> userId = AggregateReference.to(
//					userRepository.save(
//						new User(null, "testing_aggregate123", "123456",
//								"Ahmed", "Adel", "12345",
//								'M', birthdate, LocalDateTime.now(),
//								'A', "")
//					).id()
//			);

//
//			// Get breed from the db
//			AggregateReference<Breed, Long> breedId = AggregateReference.to(
//					breedRepository.findById(5L).orElse(null).id()
//			);
//
//
//
//			// It is the aggregate root for comment
//			// Creating cat for the user
//			Cat myCat = new Cat("meowiee", breedId, userId, birthdate,
//							new ArrayList<String>(List.of("image1", "image2")),
//							new ArrayList<String>(List.of("toy1", "toy2"))
//			);
//
//			myCat.addComment(
//					new Comment("Very cute cat!", "I like this car"
//					)
//			);
//
//
//			// saving the cat with comments
//			catRepository.save(myCat);

		};



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
