package com.bestseller.codingchallenge.playerapi.repository;


import com.bestseller.codingchallenge.playerapi.repository.entity.GameEntity;
import com.bestseller.codingchallenge.playerapi.repository.entity.PlayerEntity;
import com.bestseller.codingchallenge.playerapi.repository.entity.PlayerGameLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerGameLevelRepository extends JpaRepository<PlayerGameLevelEntity, Integer>,
        JpaSpecificationExecutor<PlayerGameLevelEntity> {
    @Override
    Optional<PlayerGameLevelEntity> findById(Integer integer);

    Optional<PlayerGameLevelEntity> findByPlayerAndGame(PlayerEntity player, GameEntity game);

    @Query("SELECT pgl FROM PlayerGameLevelEntity pgl WHERE pgl.game.gameId = :gameId")
    List<PlayerGameLevelEntity> findPlayerByMaxCredit(Integer gameId);

}
