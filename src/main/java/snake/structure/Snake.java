package snake.structure;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Point direction;
    private int width;
    private int height;
    private int size;
    private boolean isGrowing = false;

    public Snake(int startX, int startY, int width, int height) {
        body = new LinkedList<>();
        body.add(new Point(startX, startY));
        this.direction = new Point(1, 0);
        this.width = width;
        this.height = height;
        this.size = 1;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head.x + direction.x, head.y + direction.y);
        body.addFirst(newHead);
        if (body.size() > size) {
            body.removeLast();
        }
    }

    /* tu można połączyć z move() */
    public void grow() {
        size++;
    }

    public void setDirection(int dx, int dy) {
        if (isOppositeDirection(dx, dy)) return;
        this.direction = new Point(dx, dy);
    }

   /* public void reset(int startX, int startY) {
        body.clear();
        body.add(new Point(startX, startY));
        direction = new Point(1, 0);
        size = 1;
    }*/

    public LinkedList<Point> getBody() {
        return  body;
    }

    //getter do kierunku//
    public Point getDirection() {
        return direction;
    }

    public boolean isOppositeDirection(int dx, int dy) {
        return (direction.x + dx == 0 && direction.y + dy == 0);
    }

    public boolean checkSelfCollision() {
        Point head = body.getFirst();
        return body.stream().skip(1).anyMatch(segment -> segment.equals(head));
    }

    public boolean checkWallCollision() {
        Point head = body.getFirst();
        int x = head.x;
        int y = head.y;

        return x < 0 || x >= width || y < 0 || y >= height;
    }
}
