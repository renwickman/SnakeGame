import java.util.Scanner;

public class Game{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        do {
            Board board = new Board();
            board.playGame();
            boolean isValid = false;
            do {
                System.out.print("Try Again (Y/N)? ");
                switch (in.nextLine().toUpperCase().charAt(0)) {
                    case 'Y':
                        isValid = true;
                        board.getWindow().dispose();
                        break;
                    case 'N':
                        System.exit(0);
                    default:
                        System.out.println("Not a valid response, but nice try though");
                }
            } while (!isValid);
        } while (true);
    }

}
