
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Mancala game = new Mancala();
        int move;
        // get move from user
        try (Scanner input = new Scanner(System.in)) {
            // main game loop
            do { 
                game.printBoard();
                // usr input loop
                do {
                    System.out.println("Enter an integer in the range [1,6]: ");
                    move = input.nextInt();
                    // print message if move is invalid
                    if (!game.isValid(move)){
                        System.out.println("Not a valid move please try again.");
                    }
                } while (!game.isValid(move));

                game.makeMove(move);
                game.AIMove();
            } while (!game.checkWin());
        }
    }
}