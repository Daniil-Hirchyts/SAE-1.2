package com.example.e3;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import static com.example.e3.Ut.calculateAngle;
import static com.example.e3.Ut.calculateCoordinates;
import static com.example.e3.Ut.getNodeParametres;

public class Relation {

    private Circle node1;
    private Circle node2;
    private Line relation;

    public Relation(Circle node1, Circle node2) {
        this.node1 = node1;
        this.node2 = node2;
        connectNodes();
    }

    private void connectNodes() {
        relation = new Line();
        relation.setStrokeWidth(2);
        double[] parametres1 = getNodeParametres(node1);
        double[] parametres2 = getNodeParametres(node2);
        double angle = calculateAngle(parametres1, parametres2);
        double[] coordinates = calculateCoordinates(parametres1, parametres2, angle);
        relation.setStartX(coordinates[0]);
        relation.setStartY(coordinates[1]);
        relation.setEndX(coordinates[2]);
        relation.setEndY(coordinates[3]);
    }

    public Line getRelation() {
        return relation;
    }

    public Circle getNode1() {
        return node1;
    }

    public Circle getNode2() {
        return node2;
    }

    public void updatePosition() {
        double[] parametres1 = getNodeParametres(node1);
        double[] parametres2 = getNodeParametres(node2);
        double angle = calculateAngle(parametres1, parametres2);
        double[] coordinates = calculateCoordinates(parametres1, parametres2, angle);
        relation.setStartX(coordinates[0]);
        relation.setStartY(coordinates[1]);
        relation.setEndX(coordinates[2]);
        relation.setEndY(coordinates[3]);
    }

}
