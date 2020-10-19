public class Board {
    private String[][] board;
    private boolean isDead = false;
    int appleCount = 0;

    public Board(){
        board = new String[20][20];
        isDead = false;
        appleCount = 0;
    }

    void boardGame(){
        board = new String[20][20];
    }

}
