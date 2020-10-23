import javax.swing.*;

public class Game {

    public static void main(String[] args) {
        boolean keepRunning = true;
        do {
            Board board = new Board();
            board.playGame();
            JFrame window = board.getWindow();
            switch (JOptionPane.showConfirmDialog(window, "Would you like to try again?", "Game Over",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
                case JOptionPane.YES_OPTION:
                    break;  // do not do anything - keep the program running if the user wants to continue
                case JOptionPane.CLOSED_OPTION:
                    // Closing the prompt will do the same as clicking No - closed case falls to no case
                case JOptionPane.NO_OPTION:
                    keepRunning = false;
            }
            board.getWindow().dispose();
        } while (keepRunning);
    }

}
