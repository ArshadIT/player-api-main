package com.gamerapi.codingchallenge.playerapi.repository.entity;

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
@Table(name = "player_game_level")
@Data
public class PlayerGameLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="player_game_level_id")
    private Integer playerGameLevelId;

    @Column(name = "credit_amount")
    private Double creditAmount;

    @ManyToOne
    @JoinColumn(name="player_id")
    private PlayerEntity player;
    @ManyToOne
    @JoinColumn(name="game_id")
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name="game_level_id")
    private GameLevelEntity gameLevel;

    /*@OneToOne
    @JoinColumn(name="player_credit_id")
    private PlayerCredit playerCredit;*/

}
