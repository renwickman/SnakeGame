import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body;
    private char direction;

    public Snake(int y, int x) {
        body = new ArrayList<int[]>();
        body.add(new int[]{y, x});
        body.add(new int[]{y, x + 1});
    }

    public void move(int moveY, int moveX) {

        int y = -1;
        int x = -1;
        for (int i = 0; i < body.size(); i++) {
            if (i == 0) {
                y = body.get(0)[0];
                body.get(0)[0] += moveY;
                x = body.get(0)[1];
                body.get(0)[1] += moveX;
                continue;
            }
            int yy = body.get(i)[0];
            body.get(i)[0] = y;
            y = yy;
            int xx = body.get(i)[1];
            body.get(i)[1] = x;
            x = xx;
        }
    }

    public void grow() {
//        body.add(new int[]{});
    }

    public ArrayList<int[]> getBody(){
        return body;
    }

    public void setBody(ArrayList<int[]> body) {
        this.body = body;
    }
}
