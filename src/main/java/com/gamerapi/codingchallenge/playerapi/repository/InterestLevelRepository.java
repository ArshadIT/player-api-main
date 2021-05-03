package com.gamerapi.codingchallenge.playerapi.repository;

import com.gamerapi.codingchallenge.playerapi.repository.entity.InterestLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InterestLevelRepository extends JpaRepository<InterestLevelEntity, Integer>,
        JpaSpecificationExecutor<InterestLevelEntity> {
}
