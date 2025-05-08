package snake.structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements ActionListener {

    private static final int gridSize = 20;
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 700;
    private static final int DELAY = 300;
    private Food food;
    private Snake snake;
    private boolean gameOver;


    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
                    public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    snake.setDirection(0, -1);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    snake.setDirection(0, 1);
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    snake.setDirection(-1, 0);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    snake.setDirection(1, 0);
                }
            }
        });

        snake = new Snake(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT, gridSize);
        food = new Food(SCREEN_WIDTH, SCREEN_HEIGHT, gridSize);
        gameOver = false;

        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (gameOver) {
            g.setColor(Color.RED);
            String gameOverText = "GAME OVER";
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            g.drawString(gameOverText, (SCREEN_WIDTH - metrics.stringWidth(gameOverText)) / 2, SCREEN_HEIGHT / 2);
        } else {
            for (Point point : snake.getBody()) {
                g.setColor(Color.GREEN);
                g.fillRect(point.x, point.y, gridSize, gridSize);
            }
            food.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver) {
            snake.move();
            if (snake.checkSelfCollision() || snake.checkWallCollision()) {
                gameOver = true;
            }

            if (food.isEatenBySnake(snake)) {
                snake.grow();
                food.generateNewFood(SCREEN_WIDTH, SCREEN_HEIGHT);
            }
            repaint();
        }
    }
}
