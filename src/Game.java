import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Game extends JPanel {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Snake Game");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // kills the program when the red 'X' on the top-right is clicked
        window.setLayout(new GridBagLayout());
        window.pack();
        window.setSize(500, 500);
        window.setLocationRelativeTo(null); // centers the window to the middle of the screen
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
                System.out.print("Try Again (Y/N)? ");
                switch (in.nextLine().toUpperCase().charAt(0)) {
                    case 'Y' -> {
                        isValid = true;
                        isDone = false;
                    }
                    case 'N' -> {
                        isValid = true;
                        isDone = true;
                    }
                    default -> {
                        System.out.println("Not a valid response, but nice try though");
                        isValid = false;
                    }
                }
            } while (!isValid);
        } while (!isDone);
    }

}
