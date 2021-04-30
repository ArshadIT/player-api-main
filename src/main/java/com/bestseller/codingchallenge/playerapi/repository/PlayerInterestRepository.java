package com.bestseller.codingchallenge.playerapi.repository;

import com.bestseller.codingchallenge.playerapi.repository.entity.PlayerEntity;
import com.bestseller.codingchallenge.playerapi.repository.entity.PlayerInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


public interface PlayerInterestRepository extends JpaRepository<PlayerInterestEntity, Integer>,
        JpaSpecificationExecutor<PlayerInterestEntity> {

    Optional<List<PlayerInterestEntity>> findByPlayer(PlayerEntity player);
}
