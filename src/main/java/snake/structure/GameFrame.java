package snake.structure;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);

    }

    public void start() {
        setVisible(true);
    }
}
