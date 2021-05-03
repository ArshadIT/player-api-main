package com.gamerapi.codingchallenge.playerapi.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerGame {
    Integer playerId;
    Integer gameId;
    String gameName;

}
