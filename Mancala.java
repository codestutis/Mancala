public class Mancala {
    //margerie taylor simpson
    // first half is computers side second half is players side
    private int[] board;

    public Mancala(){
        board = new int[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
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
        index += 6;
        return !((index < 7 || index > 12)) || (board[index] == 0);
    }

    public boolean AIValid(int index){
        return !((index < 1 || index > 6)) || (board[index] == 0);
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

    public boolean checkWin(){
        return false;
    }
}