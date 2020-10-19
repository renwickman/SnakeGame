public class Board {
    private String[][] board;
    private boolean isDead = false;
    private int appleCount = 0;

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getAppleCount() {
        return appleCount;
    }

    public void setAppleCount(int appleCount) {
        this.appleCount = appleCount;
    }

    public Board(){
        board = new String[20][20];
        isDead = false;
        appleCount = 0;
        boardGame();
    }

    void boardGame(){
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++) {
                board [i] [j] = "*";
            }
        }
    }

    public void printArray() {
        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 20; ++j) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println(" ");
        }
    }

}
