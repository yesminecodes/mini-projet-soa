package com.yesmine.gamemicroservice.service;

import com.yesmine.gamemicroservice.dto.APIResponseDto;
import com.yesmine.gamemicroservice.dto.GameDto;
import com.yesmine.gamemicroservice.dto.GameMessageDto;
import com.yesmine.gamemicroservice.dto.TypeDto;
import com.yesmine.gamemicroservice.entities.Game;
import com.yesmine.gamemicroservice.exceptions.ResourceNotFoundException;
import com.yesmine.gamemicroservice.repos.GameRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GameServiceImpl implements GameService {

    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private GameRepository gameRepository;
    private APIClient apiClient;
    private StreamBridge streamBridge;

    @Override
    public APIResponseDto getGameById(Long id) {
        String dname;
        Game game = gameRepository.findById(id).get();

        TypeDto typeDto = apiClient.getTypeByCode(game.getTypeCode());

        if (typeDto == null) {
            dname = "undefined";
        } else {
            dname = typeDto.getTypeName();
        }

        GameDto gameDto = new GameDto(
                game.getId(),
                game.getName(),
                game.getTypeCode(),
                dname,
                game.getEmail(),
                game.getMobileNumber()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setGameDto(gameDto);
        apiResponseDto.setTypeDto(typeDto);

        return apiResponseDto;
    }

    @Override
    public void createGame(GameDto gameDto) {
        Game savedGame = gameRepository.save(Game.builder()
                .Name(gameDto.getName())
                .typeCode(gameDto.getTypeCode())
                .email(gameDto.getEmail())
                .mobileNumber(gameDto.getMobileNumber())
                .build());
        sendCommunication(savedGame);
    }

    private void sendCommunication(Game game) {
        var gameMsgDto = new GameMessageDto(game.getId(), game.getEmail(), game.getMobileNumber());
        log.info("Sending Communication request for the details: {}", gameMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", gameMsgDto);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }

    @Override
    public boolean updateCommunicationStatus(Long gameId) {
        boolean isUpdated = false;
        if (gameId != null) {
            Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game", "GameId", gameId.toString())
            );
            game.setCommunicationDone(true);
            gameRepository.save(game);
            isUpdated = true;
        }
        return isUpdated;

    }
}