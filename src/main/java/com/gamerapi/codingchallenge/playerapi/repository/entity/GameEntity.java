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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "game")
@Data
@NoArgsConstructor
public class GameEntity {

    public GameEntity(Integer gameId){
        this.setGameId(gameId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    Integer gameId;
    @Column(name = "game_name")
    String gameName;
}
