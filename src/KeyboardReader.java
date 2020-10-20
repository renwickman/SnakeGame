import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardReader extends KeyAdapter {
    private static Snake snake;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                break;
            default:
                System.out.println("?");
        }
    }
}
