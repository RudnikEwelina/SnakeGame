package snake.structure;

import java.awt.*;
import java.util.Random;

public class Food {
    private Point position;
    private Random random;

    public Food(int width, int height) {
        random = new Random();
        generateNewFood(width, height);
    }

    public void generateNewFood(int width, int height) {
        int x = random.nextInt(width / 10) * 10;
        int y = random.nextInt(height / 10) *10;
        position = new Point(x, y);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(position.x, position.y, 10, 10);
    }

    public boolean isEatenBySnake(Snake snake) {
        return snake.getBody().getFirst().equals(position);
    }

    public Point getPosition() {
        return position;
    }
}
