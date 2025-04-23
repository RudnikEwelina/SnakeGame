package snake.structure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.text.StyleConstants.setBackground;

public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 700;
    private static final int DELAY = 100;
    private Snake snake;


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

        snake = new Snake(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
