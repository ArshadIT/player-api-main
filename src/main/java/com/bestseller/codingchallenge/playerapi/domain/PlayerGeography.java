package com.bestseller.codingchallenge.playerapi.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlayerGeography {
    Integer playerId;
    Integer GeographyId;
    String geographyDescription;
}
