package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Fleche {
    private Polygon fleche;
    private Circle node1;
    private Circle node2;


    public Fleche(Circle node1, Circle node2) {
        this.node1 = node1;
        this.node2 = node2;
        fleche = new Polygon();
        fleche.getPoints().addAll(0.0, 0.0,
                -6.0, -6.0,
                -6.0, 6.0);
        fleche.setFill(Color.BLACK);
        updatePosition();
    }

    public Polygon getFleche() {
        return fleche;
    }

    public void updatePosition() {
        double[] parametres1 = Ut.getNodeParametres(node1);
        double[] parametres2 = Ut.getNodeParametres(node2);
        double angle = Ut.calculateAngle(parametres1, parametres2);
        double[] coordinates = Ut.calculateCoordinates(parametres1, parametres2, angle);
        fleche.setTranslateX(coordinates[2]);
        fleche.setTranslateY(coordinates[3]);
        fleche.setRotate(Math.toDegrees(angle));
    }
}
