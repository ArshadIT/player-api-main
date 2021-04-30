package com.bestseller.codingchallenge.playerapi.repository;


import com.bestseller.codingchallenge.playerapi.repository.entity.GameLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GameLevelRepository extends JpaRepository<GameLevelEntity, Integer>,
        JpaSpecificationExecutor<GameLevelEntity> {
}
