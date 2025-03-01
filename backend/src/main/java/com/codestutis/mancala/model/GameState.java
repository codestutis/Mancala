package com.codestutis.mancala.model;

import java.util.ArrayList;

/**
 * represents the board at certain point in the game
 * this will be used as the board in the mancala service class
 * an ai move will be gotten from the Ai class
 */
public class GameState {
    private int[] board; // 14 pits
    private int currentPlayer;

    public GameState() {
        // first half is opponents side backwards, second half is players side
        board = new int[]{4,4,4,4,4,4,0, 4,4,4,4,4,4,0}; // Initial state
        currentPlayer = 1;
    }

    public int[] getBoard() { return board; }
    public int getCurrentPlayer() { return currentPlayer; }
    public void setBoard(int[] board) { this.board = board; }
    public void setCurrentPlayer(int player) { this.currentPlayer = player; }

    /**
     * generates all valid moves for the current player
     * @return ArrayList of index of all valid moves
     */
    public ArrayList<Integer> validMoves() {
        int start;
        int end;

        ArrayList<Integer> moves = new ArrayList<>();

        if (currentPlayer % 2 == 1) {
            start = 7;
            end = 12;
        }
        else {
            start = 0;
            end = 5;
        }

        for (int i = start; i <= end; i++) {
            if (board[i] != 0) {
                moves.add(i);
            }
        }
        return moves;
    }
}
