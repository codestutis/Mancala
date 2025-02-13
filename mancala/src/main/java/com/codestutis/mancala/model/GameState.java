package com.codestutis.mancala.model;

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
}
