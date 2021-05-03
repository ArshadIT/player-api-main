package com.gamerapi.codingchallenge.playerapi.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interest_level")
@Data
public class InterestLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_level_id")
    private Integer interestLevelId;

    @Column(name = "level_description")
    private String levelDescription;//noob, pro, invincible
}
