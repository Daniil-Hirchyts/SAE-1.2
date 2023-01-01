package com.example.e3;

import javafx.scene.shape.Circle;

public class Ut {

    //get parametres of the nodes
    public static double[] getNodeParametres(Circle node) {
        double[] parametres = new double[3];
        parametres[0] = node.getCenterX();
        parametres[1] = node.getCenterY();
        parametres[2] = node.getRadius();
        return parametres;
    }

    //calculate the angle of the relation
    public static double calculateAngle(double[] parametres1, double[] parametres2) {
        double angle = Math.atan((parametres2[1] - parametres1[1]) / (parametres2[0] - parametres1[0]));
        return angle;
    }

    //calculate the coordinates of the relation (connect with the most close point of the nodes)
    public static double[] calculateCoordinates(double[] parametres1, double[] parametres2, double angle) {
        double[] coordinates = new double[4];
        if (parametres1[0] < parametres2[0]) {
            coordinates[0] = parametres1[0] + parametres1[2] * Math.cos(angle);
            coordinates[1] = parametres1[1] + parametres1[2] * Math.sin(angle);
            coordinates[2] = parametres2[0] - parametres2[2] * Math.cos(angle);
            coordinates[3] = parametres2[1] - parametres2[2] * Math.sin(angle);
        } else {
            coordinates[0] = parametres1[0] - parametres1[2] * Math.cos(angle);
            coordinates[1] = parametres1[1] - parametres1[2] * Math.sin(angle);
            coordinates[2] = parametres2[0] + parametres2[2] * Math.cos(angle);
            coordinates[3] = parametres2[1] + parametres2[2] * Math.sin(angle);
        }
        return coordinates;
    }
}
