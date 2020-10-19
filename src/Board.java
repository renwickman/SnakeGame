import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

public class Board {
    private String[][] board;
    private boolean isDead = false;
    private int appleCount = 0;
    private Snake snake;
    private int[] apple;

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

    public void setSnake(int row, int column){
        try{
            board[row][column] = "4";
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Snake not added, exceeds bounds of this board");
        }

    }

    public void addApple(int row, int column) {
        try {
            // TODO: Check row and column with snake
            board[row][column] = "@";
            apple = new int[]{row, column};
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Apple not added, exceeds bounds of this board");
        }
    }

    public void appleEaten(int row, int column) {
        int appleIndex = -1;
        if (apple[0] != row && apple[1] != column) {
            throw new IllegalStateException(String.format("Integrity failure: No apple exists at %s, %s", row, column));
        }
        apple = null;
        // TODO: Add 1 to the snake's length
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
