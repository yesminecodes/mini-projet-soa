package com.yesmine.gamemicroservice.repos;

import com.yesmine.gamemicroservice.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
