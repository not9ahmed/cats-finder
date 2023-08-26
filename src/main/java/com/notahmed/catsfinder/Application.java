package com.notahmed.catsfinder;

import com.notahmed.catsfinder.dto.CatDetailsNew;
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
	CommandLineRunner commandLineRunner(UserRepository userRepository, CatRepository catRepository)  {



		return args -> {


			User ann = userRepository.findById(8L).orElse(null);

			System.out.println(ann);

			List<CatDetailsNew> catAndUser = catRepository.findCatAndComments(11L);

			System.out.println("catAndUser");
			System.out.println(catAndUser);

			catAndUser.forEach(System.out::println);



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
