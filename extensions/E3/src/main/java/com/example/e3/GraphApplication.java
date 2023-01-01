package com.example.e3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class GraphApplication extends Application {

    private Random random = new Random();
    private Group root = new Group();
    private Noeud[] nodes;
    private Etiquette[] etiquettes;
    private Relation[] relations;
    private Fleche[] fleches;
    private Cycle[] cycles;
    private Button updateButton = new Button("Réinitialiser");
    public static int nbNodes = 6;
    public static int nbRelation = 8;


    public static void main(String[] args) {
        launch(args);
    }

    public static void createGraph(Group root, Random random, Noeud[] nodes, Etiquette[] etiquettes, Relation[] relations, Fleche[] fleches, Cycle[] cycles) {
        //Creation de Noeud[] nodes
        nodes = new Noeud[nbNodes];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Noeud(new Circle(), random.nextInt(500) + 50, random.nextInt(500) + 50);
            root.getChildren().add(nodes[i].getCircle());
        }

        //Creation de Etiquette[] etiquettes
        etiquettes = new Etiquette[nodes.length];
        for (int i = 0; i < etiquettes.length; i++) {
            Label label = new Label("" + i);
            etiquettes[i] = new Etiquette(label, nodes[i].getX(), nodes[i].getY());
            root.getChildren().add(etiquettes[i].getEtiquette());
        }

        //Creation de Relation[] relations
        relations = new Relation[nbRelation];
        for (int i = 0; i < relations.length; i++) {
            relations[i] = new Relation(nodes[random.nextInt(nodes.length)].getCircle(), nodes[random.nextInt(nodes.length)].getCircle());
            root.getChildren().add(relations[i].getRelation());
        }

        //Creation de Fleche[] fleches
        fleches = new Fleche[relations.length];
        for (int i = 0; i < relations.length; i++) {
            fleches[i] = new Fleche(relations[i].getNode1(), relations[i].getNode2());
            root.getChildren().add(fleches[i].getFleche());
        }

        //Creation de Cycle[] cycles
        cycles = new Cycle[2];
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = new Cycle(nodes[(random.nextInt(nodes.length))].getCircle());
            root.getChildren().add(cycles[i].getCycle());
            root.getChildren().add(cycles[i].getFlecheCycle());
        }
    }

    public void addToPane() {
                //Creation de Noeud[] nodes
        nodes = new Noeud[nbNodes];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Noeud(new Circle(), random.nextInt(500) + 50, random.nextInt(500) + 50);
            root.getChildren().add(nodes[i].getCircle());
        }

        //Creation de Etiquette[] etiquettes
        etiquettes = new Etiquette[nodes.length];
        for (int i = 0; i < etiquettes.length; i++) {
            Label label = new Label("" + i);
            etiquettes[i] = new Etiquette(label, nodes[i].getX(), nodes[i].getY());
            root.getChildren().add(etiquettes[i].getEtiquette());
        }

        //Creation de Relation[] relations
        relations = new Relation[nbRelation];
        for (int i = 0; i < relations.length; i++) {
            relations[i] = new Relation(nodes[random.nextInt(nodes.length)].getCircle(), nodes[random.nextInt(nodes.length)].getCircle());
            root.getChildren().add(relations[i].getRelation());
        }

        //Creation de Fleche[] fleches
        fleches = new Fleche[relations.length];
        for (int i = 0; i < relations.length; i++) {
            fleches[i] = new Fleche(relations[i].getNode1(), relations[i].getNode2());
            root.getChildren().add(fleches[i].getFleche());
        }

        //Creation de Cycle[] cycles
        cycles = new Cycle[2];
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = new Cycle(nodes[(random.nextInt(nodes.length))].getCircle());
            root.getChildren().add(cycles[i].getCycle());
            root.getChildren().add(cycles[i].getFlecheCycle());
        }
    }

    @Override
    public void start(Stage primaryStage) {

        createGraph(root, random, nodes, etiquettes, relations, fleches, cycles);

        updateButton.setOnAction(event -> {
            root.getChildren().clear();
            createGraph(root, random, nodes, etiquettes, relations, fleches, cycles);
            root.getChildren().add(updateButton);
        });

        root.getChildren().add(updateButton);

        Scene scene = new Scene(root, 800, 800);

        primaryStage.setTitle("Graph Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

//    private void updatePositionGraphe(){
//    }

}

