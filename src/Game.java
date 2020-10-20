import java.util.Scanner;

public class Game {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isDone = false;
        do {
            Board board = new Board();
            board.playGame();
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
