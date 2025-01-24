package com.codestutis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class MancalaTest 
{
    byte[] board = new byte[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
    Mancala game = new Mancala(board);
    @Test
    void testExtraMove(){
        //
        //
        //
        //                    fix all the +6's and -1's everywhere then it will work
        //
        //
        //
        
        // check for player
        int move = 3;
        move += 6;
        if (game.isValid(move)){
            fail("move is not valid");
        }
        game.makeMove(move);
        game.printBoard();
        assertEquals(1, game.get_num_move(), "still players move?");
        game.makeMove(1);
        // check for computer
        move = 3;
        move -= 1;
        if (!game.AIValid(move)){
            fail("move is not valid");
        }
        game.makeMove(move);
        game.printBoard();
        assertEquals(2, game.get_num_move(), "still computers move?");
    }
}