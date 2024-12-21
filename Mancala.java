
public class Mancala {
    //margerie taylor simpson
    // first half is computers side second half is players side
    private int[] board = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};

    public Mancala(){

    }

    /**
     * prints board with correct formatting
     */
    public void printBoard(){
        System.out.println(board[1]);
    }

    /**
     * 
     * @param index index of the players move
     * @return true if its a valid move
     * cant if its a store or well is empty
     */
    public boolean isValid(int index){
        index --;
        if (index < 7 || index > 12) {
            return false;
        }

        if (board[index] == 0) {
            return false;
        }
        return true;
    }

    public boolean AIValid(int index){
        index --;
        if (index < 0 || index > 5) {
            return false;
        }

        if (board[index] == 0) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param index index of players move
     * @return altered board after move was performed
     */
    public int[] makeMove(int index){
        return board;
    }

    /**
     * 
     * @return index of computer generated move
     */
    public int AIMove(){
        return 0;
    }
}
