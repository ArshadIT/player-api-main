package com.gamerapi.codingchallenge.playerapi.repository;


import com.gamerapi.codingchallenge.playerapi.repository.entity.GameLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GameLevelRepository extends JpaRepository<GameLevelEntity, Integer>,
        JpaSpecificationExecutor<GameLevelEntity> {
}
