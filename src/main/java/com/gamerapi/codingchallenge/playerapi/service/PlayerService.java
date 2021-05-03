package com.gamerapi.codingchallenge.playerapi.service;

import com.gamerapi.codingchallenge.exception.GameLevelNotFoundException;
import com.gamerapi.codingchallenge.exception.PlayerInterestNotFoundException;
import com.gamerapi.codingchallenge.exception.PlayerNotFoundException;
import com.gamerapi.codingchallenge.playerapi.domain.PlayerGame;
import com.gamerapi.codingchallenge.playerapi.domain.PlayerGeography;
import com.gamerapi.codingchallenge.playerapi.domain.PlayerLevelInfo;
import com.gamerapi.codingchallenge.playerapi.repository.GameRepository;
import com.gamerapi.codingchallenge.playerapi.repository.PlayerGameLevelRepository;
import com.gamerapi.codingchallenge.playerapi.repository.PlayerInterestRepository;
import com.gamerapi.codingchallenge.playerapi.repository.PlayerRepository;
import com.gamerapi.codingchallenge.playerapi.repository.entity.GameEntity;
import com.gamerapi.codingchallenge.playerapi.repository.entity.PlayerEntity;
import com.gamerapi.codingchallenge.util.AsyncUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerGameLevelRepository playerGameLevelRepository;
    private final PlayerInterestRepository playerInterestRepository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public CompletableFuture<PlayerLevelInfo> getPlayerLevel(Integer playerId, Integer gameId){
        return AsyncUtil.execute(() -> playerGameLevelRepository.findByPlayerAndGame(new PlayerEntity(playerId), new GameEntity(gameId)))
                .thenApply(playerGameLevelOptional ->
                        playerGameLevelOptional.map(playerGameLevel ->
                                PlayerLevelInfo.builder()
                                        .playerId(playerId)
                                        .playerName(playerGameLevel.getPlayer().getPlayerName())
                                        .gameLevel(playerGameLevel.getGameLevel().getLevelDescription())
                                        .gameId(playerGameLevel.getGame().getGameId())
                                        .gameName(playerGameLevel.getGame().getGameName())
                                        .build()
                        ).orElseThrow(GameLevelNotFoundException::new)
                );
    }

    public CompletableFuture<List<PlayerGame>> getPlayerGames(Integer playerId) {
        return AsyncUtil.execute(() -> playerInterestRepository.findByPlayer(new PlayerEntity(playerId)).orElseThrow(PlayerInterestNotFoundException::new))
                .thenApply(
                        playerInterestList -> playerInterestList.stream()
                                .map(p ->
                                        PlayerGame.builder()
                                                .playerId(playerId)
                                                .gameId(p.getGame().getGameId())
                                                .gameName(p.getGame().getGameName())
                                                .build()
                                ).collect(Collectors.toList())
                );
    }

    public CompletableFuture<PlayerGeography> getPlayerGeography(Integer playerId) {
        return AsyncUtil.execute(() -> playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new))
                .thenApply(player ->
                        PlayerGeography.builder()
                                .playerId(playerId)
                                .GeographyId(player.getPlayerGeography().getGeographyId())
                                .geographyDescription(player.getPlayerGeography().getRegion())
                                .build()
                );

    }

    public CompletableFuture<GameEntity> getPlayerWithCredits(Integer gameId) {

        return AsyncUtil.execute(() -> gameRepository.findById(gameId).orElseThrow(PlayerNotFoundException::new));
    }
}
