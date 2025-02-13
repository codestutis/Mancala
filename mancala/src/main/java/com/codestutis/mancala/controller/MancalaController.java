package com.codestutis.mancala.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codestutis.mancala.model.GameState;
import com.codestutis.mancala.service.MancalaService;


/**
 * @author Kestutis Biskis (codestutis)
 * @version 1.0.0
 * this class is the interface between the front end and the back end
 */
@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:8080")
public class MancalaController {
    // mancalaService contains game logic
    private MancalaService mancalaService;

    public MancalaController(MancalaService game) {
        this.mancalaService = game;
    }


    @GetMapping("/state")
    public GameState getGameState() {
        return mancalaService.getGameState();
    }

    @PostMapping("/move/{pitIndex}")
    public GameState makeMove(int pitIndex) { // might need @PathVariable
        return mancalaService.makeMove(pitIndex);
    }

    @PostMapping("/reset")
    public void resetGame() {
        mancalaService.resetGame();
    }
}
