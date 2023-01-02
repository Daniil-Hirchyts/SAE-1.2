package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Noeud {

    private Random random = new Random();
    private Circle circle;
    private double x;
    private double y;

    public Noeud(Circle circle, double x, double y) {
        this.circle = circle;
        this.x = x;
        this.y = y;
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(12);
        circle.setFill(Color.rgb(random.nextInt(155) + 100, random.nextInt(155) + 100, random.nextInt(155) + 100));
        circle.setStroke(Color.rgb(0, 0, 0));
        circle.setStrokeWidth(2);
    }

    public Circle getCircle() {
        return circle;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void updatePosition(double x, double y) {
        this.x = x;
        this.y = y;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    public void updateColor() {
        circle.setFill(Color.rgb(random.nextInt(155) + 100, random.nextInt(155) + 100, random.nextInt(155) + 100));
    }
}
