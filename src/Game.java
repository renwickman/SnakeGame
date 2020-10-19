import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        boolean isDone = false;
        do {
            board.boardGame();
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
        } while(!isDone);
    }

}
