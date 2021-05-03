package com.gamerapi.codingchallenge.playerapi.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerCredit {
    Integer playerId;
    Double creditAmount;
    Integer GameId;
    Integer levelId;

}
