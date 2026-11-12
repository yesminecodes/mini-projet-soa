package com.yesmine.message.functions;
import com.yesmine.message.dto.GameMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class MessageFunctions {
    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);
    @Bean
    public Function<GameMessageDto,GameMessageDto> email() {
        return gameMsgDto -> {
            log.info("Sending email with the details : " +
                    gameMsgDto.toString());
            return gameMsgDto;
        };
    }
    @Bean
    public Function<GameMessageDto,Long> sms() {
        return gameMsgDto -> {
            log.info("Sending sms with the details : " +
                    gameMsgDto.toString());
            return gameMsgDto.GameId();
        };
    }
}