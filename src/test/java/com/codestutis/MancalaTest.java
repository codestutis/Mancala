package com.codestutis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MancalaTest 
{
    byte[] board = new byte[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
    Mancala game = new Mancala(board);
    @Test
    void testAIMove(){
        int expected = 0; 
        int actual = game.AIMove();
        assertEquals(expected, actual);
    }
    
}