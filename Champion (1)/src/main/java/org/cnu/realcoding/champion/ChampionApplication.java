package org.cnu.realcoding.champion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChampionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChampionApplication.class, args);
	}

}
