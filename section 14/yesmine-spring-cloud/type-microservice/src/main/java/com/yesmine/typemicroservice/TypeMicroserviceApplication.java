package com.yesmine.typemicroservice;

import com.yesmine.typemicroservice.entities.Type;
import com.yesmine.typemicroservice.repos.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TypeMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TypeMicroserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(TypeRepository typeRepository) {
        return args -> {
            typeRepository.save(Type.builder()
                    .typeName("Multiplayer")
                    .typeCode("1000")
                    .build());
            typeRepository.save(Type.builder()
                    .typeName("FPS")
                    .typeCode("1001")
                    .build());
        };
    }

}
