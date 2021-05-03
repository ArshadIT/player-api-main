package com.gamerapi.codingchallenge.playerapi.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
public class PlayerEntity {

    public PlayerEntity(Integer playerId){
        this.setPlayerId(playerId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nick_name")
    private String nickName;

    @ManyToOne(targetEntity = PlayerInterestEntity.class)
    @JoinColumn(name="player_interest_id")
    private List<PlayerInterestEntity> playerInterestList;

    @ManyToOne
    @JoinColumn(name="geography_id")
    private GeographyEntity playerGeography;
}
