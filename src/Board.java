import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Board extends KeyAdapter {
    private boolean isDead = false;
    private final Snake snake;
    private int[] apple;
    private final int[] dimensions = new int[]{20, 20};
    private final Score score;
    private String[][] thisBoard;

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Snake getSnake() {
        return snake;
    }

    public String[][] getThisBoard() {
        return thisBoard;
    }

    public Board() {
        snake = new Snake(4, 4);
        isDead = false;
        score = new Score(0);
    }

    public void printArray() {
        System.out.println("Score: " + score.getScore());
        thisBoard = new String[dimensions[0]][dimensions[1]];
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


    void initMove(char dir) {
        switch (dir) {
            case 'U':
                snake.getBody().get(0)[0] -= 1;
                break;
            case 'R':
                snake.getBody().get(0)[1] += 1;
                break;
            case 'D':
                snake.getBody().get(0)[0] += 1;
                break;
            case 'L':
                snake.getBody().get(0)[1] -= 1;
                break;
            default:
                System.out.println("Not happening buddy!");
        }
    }

    public void gameOver() {
        isDead = true;
        System.out.println("Game Over!");
    }

    public void addApple(int row, int column) {
        if (apple != null) {
            System.out.println("Cannot add another apple; only one apple can exist");
            return;
        }
        ArrayList<int[]> snakeBody = snake.getBody();
        for (int[] section : snakeBody) {
            if (section[0] == row && section[1] == column) {
                System.out.println("Cannot add apple to top of snake");
                return;
            }
        }
        try {
            apple = new int[]{row, column};
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot add apple outside of the map");
        }
    }

    public boolean appleEaten() {
        int[] snakeHead = snake.getBody().get(0);
        if (apple[0] == snakeHead[0] && apple[1] == snakeHead[1]) {
            snake.getBody().add(new int[]{snakeHead[0] + 1, snakeHead[1] + 1});
            apple = null;
            Random rand = new Random();
            addApple(rand.nextInt(20), rand.nextInt(20));
            score.setScore(score.getScore() + 1);
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
                } else {
                    initMove('U');
                }
                break;
            case KeyEvent.VK_LEFT:
                if (snake.getBody().get(0)[1] == 0) {
                    gameOver();
                } else {
                    initMove('L');
                }
                break;
            case KeyEvent.VK_DOWN:
                if (snake.getBody().get(0)[0] == 19) {
                    gameOver();
                } else {
                    initMove('D');
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (snake.getBody().get(0)[1] == 19) {
                    gameOver();
                } else {
                    initMove('R');
                }
                break;
            default:
                System.out.println("?");
        }
        if (!isDead) {
            appleEaten();
            printArray();
        }
    }

    void playGame() {
        addApple(6, 6);
        printArray();
        do {
            System.out.print("");
        } while (!isDead);
    }
}
