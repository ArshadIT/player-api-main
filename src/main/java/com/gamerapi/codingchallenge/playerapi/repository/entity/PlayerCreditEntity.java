package com.gamerapi.codingchallenge.playerapi.repository.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_credit")
@Data
public class PlayerCreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_credit_id")
    private Integer playerCreditId;

    @Column(name = "credit_amount", nullable = false, columnDefinition = "int default 0")
    private Double creditAmount;

    /*@ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @OneToOne
    @JoinColumn(name="player_game_level_id")
    private PlayerGameLevel playerGameLevel;*/
}
