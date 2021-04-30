package com.bestseller.codingchallenge.playerapi.repository;

import com.bestseller.codingchallenge.playerapi.repository.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer>,
        JpaSpecificationExecutor<PlayerEntity> {
}
