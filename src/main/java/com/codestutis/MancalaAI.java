package com.codestutis;

public class MancalaAI {
    private Mancala game;

    public MancalaAI(Mancala game) {
        this.game = game;
    }

    public int chooseMove() {
        // Implement AI logic to choose the best move
        // For simplicity, this example chooses the first valid move
        for (int i = 0; i < 6; i++) {
            if (game.isValid(i)) {
                return i;
            }
        }
        return -1; // No valid move found
    }
}
