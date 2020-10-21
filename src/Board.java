import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Board extends KeyAdapter {
    //    private String[][] board;
    private boolean isDead = false;
    private Snake snake;
    private int[] apple;
    private int[] dimensions = new int[]{20, 20};

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Snake getSnake() {
        return snake;
    }

    public Board() {
//        board = new String[20][20];
        snake = new Snake(4, 4);
        isDead = false;
        boardGame();
    }

    public void boardGame() {
//        IntStream.range(0, board.length).forEach(i -> Arrays.fill(board[i], "*"));
    }

    public void printArray() {
        String[][] thisBoard = new String[20][20];
        for (String[] strings : thisBoard) {
            Arrays.fill(strings, "*");
        }
        if (snake.getBody() != null) {
            for (int[] snakePart : snake.getBody()) {
                thisBoard[snakePart[0]][snakePart[1]] = "S";
            }
        }
        if (apple != null) {
            thisBoard[apple[0]][apple[1]] = "@";
        }
        IntStream.range(0, 41).forEach(i -> System.out.printf("%s-%s", i != 0 ? "" : "+", i != 40 ? "" : "+\n"));
        for (String[] str : thisBoard) {
            System.out.print("| ");
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println("|");
        }
        IntStream.range(0, 41).forEach(i -> System.out.printf("%s-%s", i != 0 ? "" : "+", i != 40 ? "" : "+\n"));
    }


    void initMove(String dir) {
        switch (dir) {
            case "U":
                snake.getBody().get(0)[0] -= 1;
                break;
            case "R":
                snake.getBody().get(0)[1] += 1;
                break;
            case "D":
                snake.getBody().get(0)[0] += 1;
                break;
            case "L":
                snake.getBody().get(0)[1] -= 1;
                break;
            default:
                System.out.println("Not happening buddy!");
        }
    }

    ;

    public void gameOver(){

        System.out.println("Game Over");;
    }

    public void addApple(int row, int column) {
        if (apple != null) {
            System.out.println("Cannot add another apple; only one apple can exist");
            return;
        }
        if (snake != null) {
            ArrayList<int[]> snakeBody = snake.getBody();
            for (int[] section : snakeBody) {
                if (section[0] == row && section[1] == column) {
                    System.out.println("Cannot add apple to top of snake");
                    return;
                }
            }
        }
        try {
//            board[row][column] = "@";
            apple = new int[]{row, column};
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add apple outside of the map");
        }
    }

    public boolean appleEaten() {
        if (snake == null) {
            System.out.println("No snake");
            return false;
        }
        int[] snakeHead = snake.getBody().get(0);
        if (apple[0] == snakeHead[0] && apple[1] == snakeHead[1]) {
//            snake.getBody().add(new int[]{1, 1});
            snake.getBody().add(new int[]{snakeHead[0] + 1, snakeHead[1] + 1});
            apple = null;
            Random rand = new Random();
            addApple(rand.nextInt(20), rand.nextInt(20));
            return true;
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (snake.getBody().get(0)[0] == 0) {
                    gameOver();
                    System.out.println("You can't move up.");
                } else {
                    initMove("U");
                }
                break;
            case KeyEvent.VK_LEFT:
                if (snake.getBody().get(0)[1] == 0) {
                    gameOver();
                    System.out.println("You can't move left.");
                } else {
                    initMove("L");
                }
                break;
            case KeyEvent.VK_DOWN:
                if (snake.getBody().get(0)[0] == 19) {
                    gameOver();
                    System.out.println("You can't move down.");
                } else {
                    initMove("D");
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (snake.getBody().get(0)[1] == 19) {
                    gameOver();
                    System.out.println("You can't move right.");
                } else {
                    initMove("R");
                }
                break;
            default:
                System.out.println("?");
        }
        appleEaten();
        printArray();
    }



    void playGame() {
        addApple(6, 6);
        printArray();
        do {
            // moving
        } while (!isDead);
    }
}