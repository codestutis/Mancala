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
 * A MancalaService object is created to represent the game
 * The client can getch the game state, make moves, and reset the game
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
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
        mancalaService.makeMove(pitIndex);
        if (mancalaService.getGameState().getCurrentPlayer() % 1 == 1) {
            return mancalaService.getGameState();
        }
        else {
            return mancalaService.aiMove();
        }
    }

    @PostMapping("/game/reset")
    public GameState resetGame() {
        mancalaService.resetGame();
        return mancalaService.getGameState();
    }

    @PostMapping("/game/ai-move")
    public GameState aiMove() {
        return mancalaService.aiMove();
    }
}
