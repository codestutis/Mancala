package com.codestutis.mancala.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codestutis.mancala.model.GameState;
import com.codestutis.mancala.service.MancalaService;


/**
 * @author Kestutis Biskis (codestutis)
 * @version 1.0.0
 * this class is the interface between the front end and the back end
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MancalaController {

    private final MancalaService mancalaService;

    public MancalaController(MancalaService mancalaService) {
        this.mancalaService = mancalaService;
    }

    @GetMapping("/game/state")
    public GameState getGameState() {
        return mancalaService.getGameState();
    }

    @PostMapping("/game/move/{pitIndex}")
    public GameState makeMove(@PathVariable int pitIndex) {
        return mancalaService.makeMove(pitIndex);
    }

    @PostMapping("/game/reset")
    public GameState resetGame() {
        mancalaService.resetGame();
        return mancalaService.getGameState();
    }
}
