package com.codestutis.mancala.service;

import org.springframework.stereotype.Service;

import com.codestutis.mancala.ai.MancalaAI;
import com.codestutis.mancala.model.GameState;

/**
 * this class is used to create an instance of a game
 * there will be a GameState object to represent the board
 */
@Service
public class MancalaService {
    // make a gameState object to perform all moves on
    private GameState gameState = new GameState();

    public GameState getGameState() {
        return gameState;
    }

    public GameState makeMove(int pitIndex) {
        //TODO make a validate move function for backend validation, capture logic, and minimax.
        /*
         * Set variables to be used throughout the function
         * start is where you will start placing the beads
         * move return true if its the players move
         * mancala is the index of the player whos moving mancala
         * skip is the index of the other mancala
         * first and last represent first and last index of pits on your side (valid moves)
         * end is to keep track of where the last bead is dropped
         */
        int start = pitIndex + 1;
        int beads = gameState.getBoard()[pitIndex];
        gameState.getBoard()[pitIndex] = 0;
        boolean move = gameState.getCurrentPlayer() % 2 == 1;
        int mancala = move ? 13 : 6;
        int skip = move ? 6 : 13;
        // store where the players first and last well are
        int first = move ? 7 : 0;
        int last = move ? 12 : 5;
    

        //initiate end to keep track of where the last bead goes
        int end = 0;
        int stop = start + beads;

        // drop one bead in each well skipping the opponents mancala
        for (int i = start; i < stop; i++) {
            // use j so editing it will still run the desired amount of times
            // return to begin of the array if the index exceeds the length
            int j = i % 14;

            if (j == skip) {
                stop++;
                continue;
            }
            // drop a bead in the well
            gameState.getBoard()[j] += 1;
            end = j;

        }
        //capture
        // TODO add option for avalanche mode
        if (end >= first && end <= last && gameState.getBoard()[end] == 1  && end != mancala && gameState.getBoard()[12 - end] != 0) {
            gameState.getBoard()[end] = 0;
            gameState.getBoard()[mancala] += gameState.getBoard()[12 - end] + 1;
            gameState.getBoard()[12 - end] = 0;
        }

        // check for extra move
        // increment if not
        if (end != mancala) {
            gameState.setCurrentPlayer(gameState.getCurrentPlayer() + 1);
        }

        if (gameOver()) {
            endGame();
        }

        if (gameState.getCurrentPlayer() % 2 == 0) {

        }
        //add make move logic
        return gameState;
    }

    public boolean gameOver() {
        boolean first = true;
        boolean second = true;
        for (int i = 0; i < 6; i++) {
            if (gameState.getBoard()[i] != 0) {
                first = false;
            }
        }
        for (int i = 7; i < 13; i++) {
            if (gameState.getBoard()[i] != 0) {
                second = false;
            }
        }
        return first || second;
    }

    public void endGame() {
        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += gameState.getBoard()[i];
            gameState.getBoard()[i] = 0;
        }
        gameState.getBoard()[6] = gameState.getBoard()[6] + total;


        // Add all remaining beads from the player's side to the player's Mancala
        total = 0;
        for (int i = 7; i < 13; i++) {
            total += gameState.getBoard()[i];
            gameState.getBoard()[i] = 0;
        }
        gameState.getBoard()[13] = gameState.getBoard()[13] + total;
    }


    public void resetGame() {
        gameState = new GameState();
    }

    public GameState aiMove() {
        int move = MancalaAI.getAiMove(gameState);
        return makeMove(move);
    }
}
