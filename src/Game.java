import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Game{

    public static void main(String[] args){


        JFrame window = new JFrame("Snake Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(700, 700);
        JPanel panel = new SnakePanel();
        window.add(panel);
        window.validate();
        window.repaint();





        Scanner in = new Scanner(System.in);
        boolean isDone = false;
        do {
            Board board = new Board();
            window.addKeyListener(board);
            board.playGame();
            window.removeKeyListener(board);
            boolean isValid = false;
            do {
                System.out.print("Try Again (Y/N)? ");
                switch (in.nextLine().toUpperCase().charAt(0)) {
                    case 'Y':
                        isValid = true;
                        isDone = false;
                        break;
                    case 'N':
                        isValid = true;
                        isDone = true;
                        break;
                    default:
                        System.out.println("Not a valid response, but nice try though");
                        isValid = false;
                }
            } while (!isValid);
        } while (!isDone);
    }

}

class SnakePanel extends JPanel {

    static final int widthOfBox = 30;
    static final int heightOfBox = 30;
//    static final int UNIT_SIZE = 20;

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int[][] array = new int[20][20];
        for (int x = 0; x < array.length * widthOfBox; x += heightOfBox) {
            for (int y = 0;
                 y < array[0].length * heightOfBox;
                 y += heightOfBox) {
                graphics.drawRect(x, y, widthOfBox, heightOfBox);
            }
        }
    }
}
