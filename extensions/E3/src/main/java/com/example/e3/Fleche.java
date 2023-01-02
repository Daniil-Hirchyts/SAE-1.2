package com.example.e3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import static com.example.e3.Ut.*;

public class Fleche {
    private Polygon fleche;
    private Circle node1;
    private Circle node2;


    public Fleche(Circle node1, Circle node2) {
        this.node1 = node1;
        this.node2 = node2;
        createFleche();
    }

    private void createFleche() {
        fleche = new Polygon();
        fleche.getPoints().addAll(0.0, 0.0,
                -5.0, -5.0,
                -5.0, 5.0);
        fleche.setFill(Color.BLACK);
        double[] parametres1 = getNodeParametres(node1);
        double[] parametres2 = getNodeParametres(node2);
        double angle = calculateAngle(parametres1, parametres2);
        double[] coordinates = calculateCoordinates(parametres1, parametres2, angle);
        fleche.setTranslateX(coordinates[2]);
        fleche.setTranslateY(coordinates[3]);
        fleche.setRotate(Math.toDegrees(angle));
    }

    public Polygon getFleche() {
        return fleche;
    }

    public void updatePosition() {
        double[] parametres1 = getNodeParametres(node1);
        double[] parametres2 = getNodeParametres(node2);
        double angle = calculateAngle(parametres1, parametres2);
        double[] coordinates = calculateCoordinates(parametres1, parametres2, angle);
        fleche.setTranslateX(coordinates[2]);
        fleche.setTranslateY(coordinates[3]);
        fleche.setRotate(Math.toDegrees(angle));
    }
}
