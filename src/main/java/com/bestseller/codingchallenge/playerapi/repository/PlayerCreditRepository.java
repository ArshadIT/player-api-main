package com.bestseller.codingchallenge.playerapi.repository;

import com.bestseller.codingchallenge.playerapi.repository.entity.PlayerCreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerCreditRepository extends JpaRepository<PlayerCreditEntity, Integer>,
        JpaSpecificationExecutor<PlayerCreditEntity> {
}
