public class Mancala {
    //margerie taylor simpson
    // first half is computers side second half is players side
    private int[] board;
    private int comp_score;
    private int play_score;
    

    public Mancala(){
        board = new int[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
        comp_score = board[6];
        play_score = board[13];
    }

    /**
     * prints board with correct formatting
     */
    public void printBoard(){

        System.out.println();

        System.out.printf("%40s\n\n", "MANCALA");
        System.out.printf("%31s", " ");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d ",  board[i]);
        }

        System.out.println();

        System.out.printf("%29s", " ");
        System.out.printf("%d%13s%d", comp_score, " ", play_score);

        System.out.println();

        System.out.printf("%31s", " ");
        for (int i = 7; i <= 12; i++) {
            System.out.printf("%d ",  board[i]);
        }

        System.out.println();
        System.out.println();

        System.out.printf("%13s", " ");
        System.out.printf("Computer score: %d%12sPlayer score: %d", comp_score, " ", play_score);
        System.out.println();
        System.out.println();
    }

    public void clearTerminal(){
        
    }

    /**
     * 
     * @param index index of the players move
     * @return true if its a valid move
     * cant if its a store or well is empty
     */
    public boolean isValid(int index){
        index += 6;
        return !((index < 7 || index > 12) || (board[index] == 0));
    }

    public boolean AIValid(int index){
        return !((index < 1 || index > 6) || (board[index] == 0));
    }

    /**
     * 
     * @param index index of players move
     * @return altered board after move was performed
     */
    public int[] makeMove(int index){
        play_score = board[13];
        return board;
    }

    /**
     * 
     * @return index of computer generated move
     */
    public int AIMove(){
        comp_score = board[6];
        return 0;
    }

    public boolean checkWin(){
        return false;
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }
}