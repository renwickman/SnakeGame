import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body;
<<<<<<< Updated upstream
    private String move;
    private String direction;
<<<<<<< Updated upstream
=======
    private int x;
    private int y;

    public String move;
>>>>>>> Stashed changes
=======
    private int x;
    private int y;

>>>>>>> Stashed changes

    public Snake(int y, int x) {
        body = new ArrayList<int[]>();
        body.add(new int[]{y, x});
    }

    public void move(){

    }

    public void grow(){
        
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }


    public void setY(int y){
        this.y = y;
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
