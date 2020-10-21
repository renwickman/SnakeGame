import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body;
    private String move;
    private String direction;

    public Snake(int y, int x) {
        body = new ArrayList<int[]>();
        body.add(new int[]{y, x});
    }

    public void move() {

    }

    public void grow() {
        
    }

    public ArrayList<int[]> getBody(){
        return body;
    }

    public void setBody(ArrayList<int[]> body) {
        this.body = body;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
