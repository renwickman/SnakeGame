import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body;

    public String move;

    public Snake() {
        body = new ArrayList<>();
    }

//    public void move(){
//        switch()
//            case k
//    }

    public ArrayList<int[]> getBody(){
        return body;
    }

    public void setBody(ArrayList<int[]> body) {
        this.body = body;
    }


    public String getMove() {
        return move;
    }

    public void up(){
        move = "UP";
    }

    public void down(){
        move = "DOWN";
    }

    public void left(){
        move = "LEFT";
    }

    public void right(){
        move = "RIGHT";
    }
}
