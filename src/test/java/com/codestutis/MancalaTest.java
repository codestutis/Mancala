package com.codestutis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MancalaTest 
{

    //too many +6's and -1's
    byte[] board = new byte[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
    Mancala game = new Mancala(board);

    // seperate into test for player and test for computer
    @Test
    void testExtraMove(){
        // check for player
        int move = 9;
        game.makeMove(move);
        assertEquals(1, game.getNumMove(), "still players move?");
        game.makeMove(7);
    }
    
    @Test
    public void testComputerExtraMove(){
        
        int move = 2;
        game.makeMove(move);
        assertEquals(2, game.getNumMove(), "still computers move?");
    }
}