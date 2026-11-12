package com.yesmine.gamemicroservice.restControllers;

import com.yesmine.gamemicroservice.dto.APIResponseDto;
import com.yesmine.gamemicroservice.dto.GameDto;
import com.yesmine.gamemicroservice.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
public class GameController {
    private GameService gamesService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getGameById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(gamesService.getGameById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createGame(@RequestBody GameDto gameDto) {
        gamesService.createGame(gameDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Game created successfully");


    }
}
