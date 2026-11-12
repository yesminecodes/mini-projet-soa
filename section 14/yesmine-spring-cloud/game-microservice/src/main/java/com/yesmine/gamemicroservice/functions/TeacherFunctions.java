package com.yesmine.gamemicroservice.functions;

import com.yesmine.gamemicroservice.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class TeacherFunctions {
    private static final Logger log = LoggerFactory.getLogger(TeacherFunctions.class);
    @Bean
    public Consumer<Long> updateCommunication(GameService gameServiceService) {
        return gameId -> {
            log.info("Updating Communication status for the teacher Id : " + gameId.toString());
            gameServiceService.updateCommunicationStatus(gameId);

        };
    }
}