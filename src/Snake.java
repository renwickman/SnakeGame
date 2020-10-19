import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Integer> body;

    public String move;

    public Snake() {
        body = new ArrayList<>();
    }

//    public void move(){
//        switch()
//            case k
//    }

    public ArrayList<Integer> getBody(){
        return body;
    }

    public void setBody(ArrayList<Integer> body) {
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
