package com.yesmine.gamemicroservice;

import com.yesmine.gamemicroservice.entities.Game;
import com.yesmine.gamemicroservice.repos.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableFeignClients
public class GameMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameMicroserviceApplication.class, args);
    }
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

    @Bean
    CommandLineRunner commandLineRunner(GameRepository gameRepository) {
        return args -> {
            gameRepository.save(Game.builder()
                    .Name("Valorant")
                    .typeCode("1000")
                    .build());
        };
    }

}