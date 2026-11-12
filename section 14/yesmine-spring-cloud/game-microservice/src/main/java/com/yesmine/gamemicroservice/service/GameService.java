package com.yesmine.gamemicroservice.service;

import com.yesmine.gamemicroservice.dto.APIResponseDto;
import com.yesmine.gamemicroservice.dto.GameDto;

public interface GameService {
    APIResponseDto getGameById(Long id);
    void createGame(GameDto gameDto);
    boolean updateCommunicationStatus(Long gameId);
}
