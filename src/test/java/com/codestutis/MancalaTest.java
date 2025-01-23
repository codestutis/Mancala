package com.codestutis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class MancalaTest 
{
    Mancala game = new Mancala();
    @Test
    void testAIMove(){
        int expected = 0; 
        int actual = game.AIMove();
        assertEquals(expected, actual);
    }
}