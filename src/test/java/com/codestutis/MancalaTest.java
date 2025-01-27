package com.codestutis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MancalaTest 
{
    private Mancala game;

    @BeforeEach
    void setUp() {
        byte[] board = new byte[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
        game = new Mancala(board);
    }
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
        game.setNumMove(2);
        int move = 2;
        game.makeMove(move);
        assertEquals(2, game.getNumMove(), "still computers move?");
    }

    @Test
    public void skipComputerMancala(){
        byte[] board1 = new byte[]{4,4,4,4,4,4,0,4,4,4,4,4,9,0};
        Mancala game1 = new Mancala(board1);
    
        game1.makeMove(12);
    
        assertEquals(0, game1.getCompScore());
    }

    @Test
    public void skipPlayerMancala(){
        byte[] board1 = new byte[]{4,4,4,4,4,9,0,4,4,4,4,4,4,0};
        Mancala game1 = new Mancala(board1);
        game1.setNumMove(2);
    
        game1.makeMove(5);
    
        assertEquals(0, game1.getPlayScore());
    }

    @Test
    public void playerPoint(){
        game.makeMove(12);
        assertEquals(1, game.getPlayScore());
    }

    @Test
    public void computerPoint(){
        game.setNumMove(2);
        game.makeMove(5);
        assertEquals(1, game.getCompScore());
    }

    // test for captures on the wrong side
    @Test
    public void playerCapture(){
        byte[] board1 = new byte[]{4,4,4,4,4,4,0,1,0,4,4,4,4,0};
        Mancala game1 = new Mancala(board1);
        game1.makeMove(7);
        assertEquals(5, game1.getPlayScore(), "capture doesnt work");
        // make sure capture doesnt work on wrong side
        byte[] board2 = new byte[]{0,4,4,4,4,4,0,4,4,4,4,3,4,0};
        Mancala game2 = new Mancala(board2);
        game2.makeMove(11);
        assertEquals(1, game2.getPlayScore(), "capture works on wrong side, player gets points");
        assertEquals(0, game2.getCompScore(), "capture works on wrong side, comp gets points");
    }

    @Test
    public void computerCapture(){
        byte[] board1 = new byte[]{1,0,4,4,4,4,0,4,4,4,4,4,4,0};
        Mancala game1 = new Mancala(board1);
        game1.setNumMove(2);
        game1.makeMove(1);
        assertEquals(5, game1.getCompScore(), "capture doesnt work ");
        // make sure capture doesnt work on wrong side
        byte[] board2 = new byte[]{4,4,4,4,4,3,0,4,0,4,4,4,4,0};
        Mancala game2 = new Mancala(board2);
        game2.setNumMove(2);
        game2.makeMove(5);
        assertEquals(0, game2.getPlayScore(), "capture works on the wrong side, points go to player");
        assertEquals(1, game2.getCompScore(), "capture works on the wrong side, points go to comp");
    }
}