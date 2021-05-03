package com.gamerapi.codingchallenge.playerapi.repository;

import com.gamerapi.codingchallenge.playerapi.repository.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GameRepository  extends JpaRepository<GameEntity, Integer>,
        JpaSpecificationExecutor<GameEntity> {
}
