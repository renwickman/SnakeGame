import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridBagLayout());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setSize(500, 10);

        window.setVisible(true);
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
                System.out.println("Try Again?");
                switch (in.next().toUpperCase()){
                    case "Y":
                        isValid = true;
                        isDone = false;
                        break;
                    case "N":
                        isValid = true;
                        isDone = true;
                        break;
                    default:
                        System.out.println("Not valid, but nice try");
                        isValid = false;
                }
            } while(!isValid);

            board.printArray();
        } while(!isDone);
    }

}
