package java;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {

    private int x;
    private int y;
    private int size;
    private int direction;
    ArrayList<Point> body;

    public Snake() {
        x = 250;
        y = 250;
        size = 10;
        direction = KeyEvent.VK_RIGHT;
        body = new ArrayList<>();
        body.add(new Point(0, 0 ));
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, size, size);
    }

    public void move() {

        switch (direction) {
            case KeyEvent.VK_UP:
                y -= size;
                break;
            case KeyEvent.VK_DOWN:
                y += size;
                break;
            case KeyEvent.VK_LEFT:
                x -= size;
                break;
            case KeyEvent.VK_RIGHT:
                x -= size;
            default:
                System.out.println("Not a Know Command");
        }
        Point head = body.get(0);
        Point newHead = new Point(x,y);
        body.add(0, newHead);
        if (body.size() > size) {
            body.remove(body.size() - 1);
        }
    }

    public void setDirection(int keyCode) {
        direction = keyCode;
    }

    public boolean intersects(Food food) {
        Point head = new Point(x, y);
        Point foodPosition = food.getPosition();
        return head.equals(foodPosition);
    }

    public boolean intersectsEdge() {
        return x < 0 || x >= 500 || y < 0 || y >= 500;
    }

    public boolean intersectsBody() {
        for (int i = 1; i < body.size(); i++) {
            Point part = body.get(i);
            if (x == part.x && y == part.y) {
                return true;
            }
        }
        return false;
    }

}
