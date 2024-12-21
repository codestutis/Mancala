
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Mancala game = new Mancala();
        Scanner input = new Scanner(System.in);


        // get move from user
        int move;
        do { 
            System.out.println("Enter an integer in the range [1,6]: ");
            move = input.nextInt();
            // print message if move is invalid
            if (!game.isValid(move)){
                System.out.println("Not a valid move please try again.");
            }
        } while (!game.isValid(move));
        input.close();
        System.out.println(move);
    }
}