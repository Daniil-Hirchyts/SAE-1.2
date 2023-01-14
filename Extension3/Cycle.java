package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Cycle {
    private Circle node;
    private Arc cycle;
    private Polygon flecheCycle;

    public Cycle(Circle node) {
        this.node = node;
        createCycle();
    }

    private void createCycle() {
        cycle = new Arc();
        cycle.setType(ArcType.OPEN);
        cycle.setRadiusX(10);
        cycle.setRadiusY(20);
        cycle.setStartAngle(-225);
        cycle.setLength(270);
        cycle.setFill(Color.rgb(0, 0, 0, 0));
        cycle.setStroke(Color.rgb(0, 0, 0));
        cycle.setStrokeWidth(2);
        flecheCycle = new Polygon();
        flecheCycle.getPoints().addAll(0.0, 0.0,
                -6.0, -6.0,
                -6.0, 6.0);
        flecheCycle.setFill(Color.BLACK);
        flecheCycle.setRotate(-120);
        updatePosition();
    }

    public Arc getCycle() {
        return cycle;
    }

    public Polygon getFlecheCycle() { return flecheCycle; }

    public void updatePosition() {
        cycle.setCenterX(node.getCenterX());
        cycle.setCenterY(node.getCenterY() + 27);
        flecheCycle.setTranslateX(node.getCenterX() + 10);
        flecheCycle.setTranslateY(node.getCenterY() + 15);
    }

}
