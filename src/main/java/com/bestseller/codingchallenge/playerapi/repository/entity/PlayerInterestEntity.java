package com.bestseller.codingchallenge.playerapi.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_interest")
@Data
public class PlayerInterestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_interest_id")
    private Integer playerInterestId;

    @ManyToOne(targetEntity = PlayerEntity.class)
    @JoinColumn(name="player_id")
    private PlayerEntity player;

    @ManyToOne(targetEntity = GameEntity.class)
    @JoinColumn(name="game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name="interest_level_id")
    private InterestLevelEntity interestLevel;


}
