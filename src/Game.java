import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Game{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean isDone = false;
        do {
            Board board = new Board();
            board.playGame();
            boolean isValid = false;
            do {
                System.out.print("Try Again (Y/N)? ");
                switch (in.nextLine().toUpperCase().charAt(0)) {
                    case 'Y':
                        isValid = true;
                        isDone = false;
                        board.getWindow().dispose();
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
