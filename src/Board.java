import java.awt.event.KeyEvent;

public class Board {
    private String[][] board;
    private boolean isDead = false;
    private int appleCount = 0;
    private Snake snake;

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

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_KP_UP && snake.getMove() != "DOWN"){
            snake.up();
        }
        else if(keyCode == KeyEvent.VK_KP_DOWN && snake.getMove() != "UP"){
            snake.down();
        }
        else if(keyCode == KeyEvent.VK_KP_LEFT && snake.getMove() != "RIGHT"){
            snake.left();
        }
        else if(keyCode == KeyEvent.VK_KP_RIGHT && snake.getMove() != "LEFT"){
            snake.right();
        }

    }

}
