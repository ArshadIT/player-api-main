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
@Table(name = "game_level")
@Data
public class GameLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_level_id")
    private Integer gameLevelId;

    @Column(name = "level_description")
    private String levelDescription;

    @ManyToOne
    @JoinColumn(name="game_id")
    private GameEntity game;
}
