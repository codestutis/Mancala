public class Mancala {
    // first half is computers side second half is players side
    private int[] board = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};

    public Mancala(){

    }

    /**
     * prints board with correct formatting
     */
    public void printBoard(){
        System.out.println(board);
    }

    /**
     * 
     * @param index index of the players move
     * @return true if its a valid move
     */
    public boolean isValid(int index){
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
