package com.gamerapi.codingchallenge.playerapi.controller;

import com.gamerapi.codingchallenge.playerapi.domain.PlayerGeography;
import com.gamerapi.codingchallenge.playerapi.domain.PlayerLevelInfo;
import com.gamerapi.codingchallenge.playerapi.service.CreditService;
import com.gamerapi.codingchallenge.playerapi.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/player")
public class PlayerController {

    private final PlayerService playerService;
    private final CreditService creditService;

    @RequestMapping(value = "ping", method = GET, headers = "Accept=application/json")
    public String ping() {
        return "PONG";
    }

    @RequestMapping(value = "{playerId}/game/{gameId}/playerlevelinfo", method = GET, headers = "Accept=application/json")
    public CompletableFuture<ResponseEntity<PlayerLevelInfo>> getPlayerLevel(@PathVariable Integer playerId, @PathVariable Integer gameId) {
        return playerService.getPlayerLevel(playerId, gameId)
                .thenApply(ResponseEntity::ok);
    }

    @RequestMapping(value = "{playerId}/games", method = GET, headers = "Accept=application/json")
    public CompletableFuture<ResponseEntity<? extends List>> getPlayerGames(@PathVariable Integer playerId) {
        return playerService.getPlayerGames(playerId)
                .thenApply(ResponseEntity::ok);
    }

    @RequestMapping(value = "{playerId}/geography", method = GET, headers = "Accept=application/json")
    public CompletableFuture<ResponseEntity<PlayerGeography>> getPlayerGeography(@PathVariable Integer playerId) {
        return playerService.getPlayerGeography(playerId)
                .thenApply(ResponseEntity::ok);
    }

    @RequestMapping(value = "{playerId}/game/{gameId}/assigncredits", method = PUT, headers = "Accept=application/json")
    public CompletableFuture<ResponseEntity> updatePlayerCredits(
            @PathVariable Integer playerId,
            @PathVariable Integer gameId,
            @RequestParam Double creditAmount
    ) {
        return creditService.updatePlayerCredits(playerId, gameId, creditAmount)
                .thenApply(ResponseEntity::ok);
    }

   }
