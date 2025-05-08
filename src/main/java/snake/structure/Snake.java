package snake.structure;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Point direction;
    private int width;
    private int height;
    private int size;
    private int gridSize;

    public Snake(int startX, int startY, int width, int height, int gridSize) {
        this.gridSize = gridSize;
        body = new LinkedList<>();
        body.add(new Point(startX, startY));
        this.direction = new Point(1, 0);
        this.width = width;
        this.height = height;
        this.size = 1;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head.x + direction.x * gridSize, head.y + direction.y * gridSize);
        body.addFirst(newHead);
        if (body.size() > size) {
            body.removeLast();
            System.out.println("Wąż się poruszył na: " + body.getFirst());
        }
    }

    public void grow() {
        size++;
    }

    public void setDirection(int dx, int dy) {
        if (isOppositeDirection(dx, dy)) return;
        this.direction = new Point(dx, dy);
    }

    public boolean isOppositeDirection(int dx, int dy) {
        return (direction.x + dx == 0 && direction.y + dy == 0);
    }

    public boolean checkSelfCollision() {
        Point head = body.getFirst();
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i).equals(head)) {
                return true;
            }
        }
        return  false;
    }

    public boolean checkWallCollision() {
        Point head = body.getFirst();
        int x = head.x;
        int y = head.y;
        return x < 0 || x >= width || y < 0 || y >= height;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.getFirst();
    }
}
