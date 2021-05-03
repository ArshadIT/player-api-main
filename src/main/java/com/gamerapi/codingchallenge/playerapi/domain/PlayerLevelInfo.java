package com.gamerapi.codingchallenge.playerapi.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerLevelInfo{
    Integer playerId;
    String playerName;
    String gameLevel;
    Integer gameId;
    String gameName;
}