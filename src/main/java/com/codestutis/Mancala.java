package com.codestutis;

/**
 * all mancala functions and stuff.
 * @author Kestutis Biskis (codestutis)
 * @version 1.0.0
 */
public class Mancala {
    //margerie taylor simpson
    @SuppressWarnings("FieldMayBeFinal")
    private byte[] board;
    private int compScore;
    private int playScore;
    private int numMove;
    

    /**
     * 
     * @param board starting board for the game
     */
    public Mancala(byte[] board) {
        this.board = board;
        compScore = board[6];
        playScore = board[13];
        numMove = 1;
    }

    /**
     * 
     * @return computers current score
     */
    public int getCompScore() {
        return this.compScore;
    }

    /**
     * 
     * @param score change the computers score
     */
    public void setCompScore(int score) {
        this.compScore = score;
    }

    /**
     * 
     * @return players score. int
     */
    public int getPlayScore() {
        return this.playScore;
    }

    /**
     * 
     * @param score change the players score
     */
    public void setPlayScore(int score) {
        this.playScore = score;
    }

    /**
     * 
     * @return int. move number. odd if players move, even if computers move
     */
    public int getNumMove() {
        return this.numMove;
    }

    /**
     * 
     * @param numMove int, odd means players move, even is computer move
     */
    public void setNumMove(int numMove) {
        this.numMove = numMove;
    }

    /**
     * 
     * @return current state of the board
     */
    public byte[] getBoard() {
        return board;
    }

    /**
     * prints board with correct formatting.
     */
    public void printBoard() {
        clearTerminal();

        System.out.println();

        System.out.printf("%40s\n\n", "MANCALA");
        System.out.printf("%31s", " ");
        for (int i = 5; i >= 0; i--) {
            System.out.printf("%d ",  board[i]);
        }

        System.out.println();

        System.out.printf("%29s", " ");
        System.out.printf("%d%13s%d", compScore, " ", playScore);

        System.out.println();

        System.out.printf("%31s", " ");
        for (int i = 7; i <= 12; i++) {
            System.out.printf("%d ",  board[i]);
        }

        System.out.println();
        System.out.println();

        System.out.printf("%13s", " ");
        System.out.printf("Computer score: %d%12sPlayer score: %d", compScore, " ", playScore);
        System.out.println();
        System.out.println();
    }

    /** 
     * clear the terminal before printing again so it looks nicer.
     */

    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * 
     * @param index index of the players move
     * @return true if the move is on the correct side of the board and the spot isnt empty
     * 
     */

    public boolean isValid(int index) {
        index += 6;
        return !(index < 7 || index > 12 || board[index] == 0);
    }
    /**
     * 
     * @param index index of the piece that is being moved
     * @return true if the move is on the correct side of the board and the spot isnt empty
     */

    public boolean isAiValid(int index) {
        return !(index < 0 || index > 5 || board[index] == 0);
    }

    /**
     * 
     * @param index index of players move
     * @return altered board after move was performed
     */
    public byte[] makeMove(int index) {
        int start = index + 1;
        int beads = board[index];
        board[index] = 0;
        int mancala;
        int skip;
        int first;
        int last;
        mancala = whosMove() ? 13 : 6;
        skip = whosMove() ? 6 : 13;
        first = whosMove() ? 7 : 0;
        last = whosMove() ? 12 : 5;
        int end = 0;
        int stop = start + beads;
        // place beads one at a time
        for (int i = start; i < stop; i++) {
            // use j so editing it will still run the desired amount of times
            // return to begin of the array if the index exceeds the length
            int j = i % 14;

            if (j == skip) {
                stop++;
                continue;
            }
            // drop a bead in the well
            board[j] += 1;
            end = j;
        }
        //capture
        if (end >= first && end <= last && board[end] == 1  && end != mancala && board[12 - end] != 0) {
            board[end] = 0;
            board[mancala] += board[12 - end] + 1;
            board[12 - end] = 0;
        }

        numMove++;
        // extra move
        if (end == mancala) {
            numMove--;
        }

        playScore = board[13];
        compScore = board[6];
        return board;
    }

    /**
     * 
     * @return index of computer generated move
     */
    public int makeAiMove() {
        compScore = board[6];
        return 0;
    }
    
    /**
     * 
     * @return boolean, false if no one has won, true if someone won.
     */
    public boolean gameOver() {
        boolean first = true;
        boolean second = true;
        for (int i = 0; i < 6; i++) {
            if (board[i] != 0) {
                first = false;
            }
        }
        for (int i = 7; i < 13; i++) {
            if (board[i] != 0) {
                second = false;
            }
        }
        return first || second;
    }

    /**
     * 
     * @return boolean. True if its the players move, false if its the computers move.
     */
    public boolean whosMove() {
        // players moves are odd
        return (numMove % 2) == 1;
    }
    /**
     * check if either side of the board is empty.
     * if so end the game and add all the pieces on the other side to the other mancala.
     */

    public void endGame() {
        // Add all remaining beads from the computer's side to the computer's Mancala
        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += board[i];
            board[i] = 0;
        }
        setCompScore(getCompScore() + total);

        // Add all remaining beads from the player's side to the player's Mancala
        total = 0;
        for (int i = 7; i < 13; i++) {
            total += board[i];
            board[i] = 0;
        }
        setPlayScore(getPlayScore() + total);
    }
}
