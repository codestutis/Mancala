package com.codestutis.mancala.ai;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codestutis.mancala.model.GameState;

/**
 * TODO make minimax algorithm
 * 
 * right now just pick a random move from array of valid moves
 * get ai move should be static
 */
@Service
public class MancalaAI {

    public static int getAiMove(GameState gameState) {
        List<Integer> moves = gameState.validMoves();
        int rand = (int) (Math.random() * moves.size());
        return moves.get(rand);
    }
    
}
