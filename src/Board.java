import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Board {
    private String[][] board;
    private boolean isDead = false;
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

    public Board(){
        board = new String[20][20];
        snake = new Snake(4,4);
        board[4][4] = "S";  // THIS MUST BE DONE WHEN INITIALIZING SNAKE OR SNAKE MUST STORE REFERENCE TO BOARD
        isDead = false;
        boardGame();
    }

    public void boardGame() {
        IntStream.range(0, board.length).forEach(i -> Arrays.fill(board[i], "*"));
    }

    public void printArray() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; ++j) {
                int[] snakeHead = snake != null ? snake.getBody().get(0) : new int[]{-1, -1};
                if (snakeHead[0] == i && snakeHead[1] == j) {
                    board[i][j] = "S";
                }
                System.out.printf("%s  %s", board[i][j], j != board[i].length - 1 ? "" : "\n");
            }
        }
    }

    public boolean addApple(int row, int column) {
        if (apple != null) {
            System.out.println("Cannot add another apple; only one apple can exist");
            return false;
        }
        if (snake != null) {
            ArrayList<int[]> snakeBody = snake.getBody();
            for (int[] section : snakeBody) {
                if (section[0] == row && section[1] == column) {
                    System.out.println("Cannot add apple to top of snake");
                    return false;
                }
            }
        }
        try {
            board[row][column] = "@";
            apple = new int[]{row, column};
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add apple outside of the map");
            return false;
        }
    }

    public boolean appleEaten() {
        if (snake == null) {
            System.out.println("No snake");
            return false;
        }
        int[] snakeHead = snake.getBody().get(0);
        if (apple[0] != snakeHead[0] && apple[1] != snakeHead[1]) {
            return false;
        }
        apple = null;
//        snake.getBody().add(1, snake);
        // TODO: Add 1 to the snake's length
        return true;
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

    void playGame(){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        addApple(6, 6);
        printArray();
        do {
            do{
                //moving


            } while(appleEaten() == false);
            addApple(rand.nextInt(10), rand.nextInt(10));
        } while (!isDead);
    }


}
