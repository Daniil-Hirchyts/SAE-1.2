package com.example.e3;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Graph {
    private Noeud[] nodes;
    private Etiquette[] etiquettes;
    private Relation[] relations;
    private Fleche[] fleches;
    private Cycle[] cycles;
    private int[][] matrix;

    public Graph(Noeud[] nodes, Etiquette[] etiquettes, Relation[] relations, Fleche[] fleches, Cycle[] cycles, int[][] matrix) {
        this.nodes = nodes;
        this.etiquettes = etiquettes;
        this.relations = relations;
        this.fleches = fleches;
        this.cycles = cycles;
        this.matrix = matrix;
    }

    public void createGraph(Random random, Noeud[] nodes, Etiquette[] etiquettes, Relation[] relations, Fleche[] fleches, Cycle[] cycles) {
        int tempCountCycles = 0, tempCountRelations = 0;
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Noeud(new Circle(), random.nextInt(500) + 50, random.nextInt(500) + 50);
            Label label = new Label("" + (i + 1));
            etiquettes[i] = new Etiquette(label, nodes[i].getX(), nodes[i].getY());
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1 && i != j) {
                    relations[tempCountRelations] = new Relation(nodes[i].getCircle(), nodes[j].getCircle());
                    fleches[tempCountRelations] = new Fleche(relations[i].getNode1(), relations[i].getNode2());
                    tempCountRelations++;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j && matrix[i][j] == 1) {
                    cycles[tempCountCycles] = new Cycle(nodes[i].getCircle());
                    tempCountCycles++;
                }
            }
        }
    }

    public void addToRoot(Pane root, Noeud[] nodes, Etiquette[] etiquettes, Relation[] relations, Fleche[] fleches, Cycle[] cycles) {
        for (int i = 0; i < nodes.length; i++) {
            root.getChildren().add(nodes[i].getCircle());
            nodes[i].getCircle().toFront();
            root.getChildren().add(etiquettes[i].getEtiquette());
        }
        for (int i = 0; i < relations.length; i++) {
            root.getChildren().add(relations[i].getRelation());
            root.getChildren().add(fleches[i].getFleche());
        }
        for (int i = 0; i < cycles.length; i++) {
            root.getChildren().add(cycles[i].getCycle());
            root.getChildren().add(cycles[i].getFlecheCycle());
        }
    }

}
