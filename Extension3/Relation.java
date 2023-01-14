package application;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Relation {
    private Circle node1;
    private Circle node2;
    private Line relation;

    public Relation(Circle node1, Circle node2) {
        this.node1 = node1;
        this.node2 = node2;
        relation = new Line();
        relation.setStrokeWidth(2);
        updatePosition();
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
        double[] parametres1 = Ut.getNodeParametres(node1);
        double[] parametres2 = Ut.getNodeParametres(node2);
        double angle = Ut.calculateAngle(parametres1, parametres2);
        double[] coordinates = Ut.calculateCoordinates(parametres1, parametres2, angle);
        if (parametres1[0] <= parametres2[0]) {
            relation.setStartX(coordinates[0]);
            relation.setStartY(coordinates[1]);
            relation.setEndX(coordinates[2]);
            relation.setEndY(coordinates[3]);
        } else {
            relation.setStartX(coordinates[2]);
            relation.setStartY(coordinates[3]);
            relation.setEndX(coordinates[0]);
            relation.setEndY(coordinates[1]);
        }
    }
}
