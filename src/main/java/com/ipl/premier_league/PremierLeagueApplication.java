package com.ipl.premier_league;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PremierLeagueApplication {

	public static void main(String[] args) {
		String mongoUri = System.getenv("MONGO_URI");
		System.out.println("MONGO_URI: " + mongoUri);
		SpringApplication.run(PremierLeagueApplication.class, args);
	}

}
