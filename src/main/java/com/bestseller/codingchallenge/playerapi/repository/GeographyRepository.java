package com.bestseller.codingchallenge.playerapi.repository;


import com.bestseller.codingchallenge.playerapi.repository.entity.GeographyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GeographyRepository extends JpaRepository<GeographyEntity, Integer>,
        JpaSpecificationExecutor<GeographyEntity> {
}
