package com.gamerapi.codingchallenge.playerapi.repository;

import com.gamerapi.codingchallenge.playerapi.repository.entity.PlayerCreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerCreditRepository extends JpaRepository<PlayerCreditEntity, Integer>,
        JpaSpecificationExecutor<PlayerCreditEntity> {
}
