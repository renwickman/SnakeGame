public class Score {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    //Increments Score and prints it out
    public void incrementScore(Board board){
        if(ateApple(board)) score++;
        System.out.println("Score: " + score);
    }
    //Checks if apple was eaten
    public boolean ateApple(Board board){
        for (String [] array: board.getThisBoard()) {
            for (String element: array){
                if(element.equals("@"))
                    return false;
            }
        }
        return true;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
