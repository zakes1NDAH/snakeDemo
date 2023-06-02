package java;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food {

    private int x;
    private int y;
    private int size;

    public Food() {
        size = 10;
        Random rand = new Random();
        x = rand.nextInt(49) * size;
        y = rand.nextInt(49) * size;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);
    }

    public Point getPosition() {
        return new Point(x, y);
    }

}
