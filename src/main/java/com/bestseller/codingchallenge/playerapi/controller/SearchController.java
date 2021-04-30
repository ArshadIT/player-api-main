package com.bestseller.codingchallenge.playerapi.controller;

import com.bestseller.codingchallenge.playerapi.domain.PlayerCredit;
import com.bestseller.codingchallenge.playerapi.service.CreditService;
import com.bestseller.codingchallenge.playerapi.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
@RequestMapping(value = "/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final CreditService creditService;
    private final PlayerService playerService;

    @RequestMapping(value = "game/{gameId}/playerwithmaxcredits", method = GET, headers = "Accept=application/json")
    public CompletableFuture<ResponseEntity<List<PlayerCredit>>> getPlayerWithCredits(@PathVariable Integer gameId) {
        return creditService.getPlayerWithMaxCredits(gameId)
                .thenApply(ResponseEntity::ok);
    }
}
