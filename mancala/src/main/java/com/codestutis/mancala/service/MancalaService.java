package com.codestutis.mancala.service;

import org.springframework.stereotype.Service;

import com.codestutis.mancala.model.GameState;

@Service
public class MancalaService {
    // make a gameState object to perform all moves on
    private GameState gameState = new GameState();

    public GameState getGameState() {
        return gameState;
    }

    public GameState makeMove(int pitIndex) {
        //add make move logic
        return gameState;
    }

    public void resetGame() {
        gameState = new GameState();
    }
}
