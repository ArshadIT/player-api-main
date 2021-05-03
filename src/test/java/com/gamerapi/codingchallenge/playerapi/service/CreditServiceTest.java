package com.gamerapi.codingchallenge.playerapi.service;

import com.gamerapi.codingchallenge.playerapi.domain.PlayerCredit;
import com.gamerapi.codingchallenge.playerapi.repository.PlayerGameLevelRepository;
import com.gamerapi.codingchallenge.playerapi.repository.entity.GameEntity;
import com.gamerapi.codingchallenge.playerapi.repository.entity.PlayerEntity;
import com.gamerapi.codingchallenge.playerapi.repository.entity.PlayerGameLevelEntity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditServiceTest {

    public CreditService creditService;
    private final PlayerGameLevelRepository playerGameLevelRepository = mock(PlayerGameLevelRepository.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init(){
        creditService = Mockito.spy(new CreditService(playerGameLevelRepository));
    }

    @Test
    public void getPlayerWithMaxCredits() throws ExecutionException, InterruptedException {
        final Integer mockGameId1 = 1;
        final Integer mockPlayerId1 = 1;
        final Integer mockPlayerId2 = 2;

        final PlayerGameLevelEntity playerGameLevelEntity1 = getPlayerGameLevelEntity(mockGameId1, mockPlayerId1);
        final PlayerGameLevelEntity playerGameLevelEntity2 = getPlayerGameLevelEntity(mockGameId1, mockPlayerId2);
        List<PlayerGameLevelEntity> mockPlayerGameList = Arrays.asList(playerGameLevelEntity1, playerGameLevelEntity2);

        when(playerGameLevelRepository.findPlayerByMaxCredit(eq(mockGameId1))).thenReturn(mockPlayerGameList);

        final List<PlayerCredit> playerWithMaxCredits = creditService.getPlayerWithMaxCredits(mockGameId1).get();

        assertEquals(2, playerWithMaxCredits.size());
        assertEquals(playerWithMaxCredits.get(0).getGameId(), mockGameId1);
        assertEquals(playerWithMaxCredits.get(0).getPlayerId(), mockPlayerId1);
        assertEquals(playerWithMaxCredits.get(1).getGameId(), mockGameId1);
        assertEquals(playerWithMaxCredits.get(1).getPlayerId(), mockPlayerId2);
    }

    @Test
    public void getPlayerWithMaxCreditsThrowsException() throws ExecutionException, InterruptedException {
        expectedException.expect(ExecutionException.class);
        expectedException.expectMessage("could not fetch game level");
        when(playerGameLevelRepository.findPlayerByMaxCredit(anyInt())).thenThrow(new RuntimeException("some exception"));

        creditService.getPlayerWithMaxCredits(1).get();
    }

    private static PlayerGameLevelEntity getPlayerGameLevelEntity(Integer mockGameId, Integer mockPlayerId){
        PlayerGameLevelEntity playerGameLevelEntity = new PlayerGameLevelEntity();
        playerGameLevelEntity.setGame(new GameEntity(mockGameId));
        playerGameLevelEntity.setPlayer(new PlayerEntity(mockPlayerId));
        playerGameLevelEntity.setCreditAmount(200.0d);
        playerGameLevelEntity.setPlayerGameLevelId(1);

        return playerGameLevelEntity;
    }

}