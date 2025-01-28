package com.codestutis;

import java.util.Scanner;

/**
 * @author Kestutis Biskis
 * @version 1.0.0
 */
public class Main {

    /**
     * 
     * @param args string or something idk
     */
    public static void main(String[] args) {
        // first half is computers side second half is players side
        byte[] board = new byte[]{4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
        Mancala game = new Mancala(board);
        int move;
        // get move from user
        try (Scanner input = new Scanner(System.in)) {
            // main game loop
            do {
                game.printBoard();
                if (game.whosMove()) {
                    // usr input loop
                    do {
                        System.out.print("Enter an integer in the range [1,6]: ");
                        move = input.nextInt();
                        // print message if move is invalid
                        if (!game.isValid(move)) {
                            System.out.println("Not a valid move please try again.");
                        }
                    } while (!game.isValid(move));
                    // make player move and adjust for player board being second half of array
                    game.makeMove(move + 6);
                } else {
                    //computer move

                    // get move from user for testing purposes
                    // temporary
                    do {
                        System.out.print("Enter Computer move: ");
                        move = input.nextInt();
                        // print message if move is invalid
                        if (!game.isAiValid(move)) {
                            System.out.println("Not a valid move please try again.");
                        }
                    } while (!game.isAiValid(move - 1));
                    // make player move and adjust for player board being second half of array
                    game.makeMove(move - 1);
                }
                // AI move loop
                
            } while (!game.gameOver());
            game.endGame();
            game.printBoard();
            System.out.println("Game over!");
        }
    }
}
