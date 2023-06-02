package java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener {

    private Timer timer;
    private Snake snake;
    private Food food;
    private int score;

    public SnakeGame() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new SnakeKeyListener());

        snake = new Snake();
        food = new Food();
        timer = new Timer(100, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        food.draw(g);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.intersects(food)) {
            food = new Food();
            score++;
        }
        if (snake.intersectsEdge() || snake.intersectsBody()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over. Score: " + score);
        }
        repaint();
    }

    private class SnakeKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            snake.setDirection(e.getKeyCode());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
