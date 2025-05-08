package snake.structure;

import java.awt.*;
import java.util.Random;

public class Food {
    private Point position;
    private Random random;
    private int gridSize;

    public Food(int width, int height, int gridSize) {
        this.gridSize = gridSize;
        random = new Random();
        generateNewFood(width, height);
    }

    public void generateNewFood(int width, int height) {
        int x = random.nextInt(width / gridSize) * gridSize;
        int y = random.nextInt(height / gridSize) * gridSize;
        position = new Point(x, y);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(position.x, position.y, gridSize, gridSize);
    }

    public boolean isEatenBySnake(Snake snake) {
        return snake.getHead().equals(position);
    }
}
