package application;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GraphView {

    public static int nbRelation;
    public static int nbNodes;
    private static Random random = new Random();
    private static Pane root = new Pane();
    private static Noeud[] nodes;
    private static Etiquette[] etiquettes;
    private static Relation[] relations;
    private static Fleche[] fleches;
    private static Cycle[] cycles;
    private VBox dialogBox = new VBox();

    public static void show(Stage primaryStage, int[][] matrix) {
        nbNodes = matrix.length;
        int nbRelationT = 0;
        int nbCycle = 0;
        for (int i = 0; i < nbNodes; i++) {
            for (int j = 0; j < nbNodes; j++) {
                if (matrix[i][j] == 1 && i != j) nbRelationT++;
                if (i == j && matrix[i][j] == 1) nbCycle++;
            }
        }
        nbRelation = nbRelationT;

        nodes = new Noeud[nbNodes];
        etiquettes = new Etiquette[nbNodes];
        relations = new Relation[nbRelation];
        fleches = new Fleche[nbRelation];
        cycles = new Cycle[nbCycle];

        Graph graph = new Graph(nodes, etiquettes, relations, fleches, cycles, matrix);
        graph.createGraph(random, nodes, etiquettes, relations, fleches, cycles);
        graph.addToRoot(root, nodes, etiquettes, relations, fleches, cycles);

        Menu modifierMenu = new Menu("Graphe");
        MenuItem recommencer = new MenuItem("Recommencer");
        MenuItem save = new MenuItem("Sauvegarder");
        MenuItem reinitialiserMenuItem = new MenuItem("Réinitialiser la position");
        MenuItem couleurMenuItem = new MenuItem("Changer les couleurs");
        modifierMenu.getItems().addAll(recommencer, save, reinitialiserMenuItem, couleurMenuItem);

        Menu applicationMenu = new Menu("Application");
        MenuItem quitterMenuItem = new MenuItem("Quitter");
        applicationMenu.getItems().addAll(quitterMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(modifierMenu, applicationMenu);

        recommencer.setOnAction(event -> {
            try {
                root.getChildren().clear();
                primaryStage.close();
                MatrixDialog.show(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        save.setOnAction(event -> {
            try {
                Robot robot = new Robot();
                BufferedImage bi = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(bi, "png", new File("screenshot.png"));
            } catch (AWTException | IOException e) {
                e.printStackTrace();
            }
        });
        reinitialiserMenuItem.setOnAction(event -> {
            updatePositionGraphe(root, random, nodes, etiquettes, relations, fleches, cycles);
        });
        quitterMenuItem.setOnAction(event -> {
            System.exit(0);
        });
        couleurMenuItem.setOnAction(event -> {
            for (Noeud node : nodes) node.updateColor();
        });

        root.setPrefSize(600, 600);
        for (int i = 0; i < nodes.length; i++) {
            int finalI = i;
            nodes[i].getCircle().setOnMouseEntered(event -> {
                nodes[finalI].getCircle().setCursor(javafx.scene.Cursor.OPEN_HAND);
            });
            nodes[i].getCircle().setOnMouseDragged(event -> {
                nodes[finalI].getCircle().setCursor(javafx.scene.Cursor.CLOSED_HAND);
                nodes[finalI].updatePosition(event.getX(), event.getY());
                etiquettes[finalI].updatePosition(nodes[finalI].getX(), nodes[finalI].getY());
                for (int j = 0; j < relations.length; j++) {
                    relations[j].updatePosition();
                    fleches[j].updatePosition();
                }
                for (Cycle cycle : cycles) cycle.updatePosition();
            });
        }

        menuBar.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");

        VBox vBox = new VBox();

        VBox mainBox = new VBox();

        vBox.getChildren().addAll(menuBar);
        mainBox.getChildren().addAll(vBox, root);

        primaryStage.setScene(new Scene(mainBox));
        primaryStage.setTitle("Graphes - Application");
        primaryStage.show();
    }

    private static void updatePositionGraphe(Pane root, Random random, Noeud[] nodes, Etiquette[] etiquettes, Relation[] relations, Fleche[] fleches, Cycle[] cycles) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].updatePosition(random.nextInt(500) + 50, random.nextInt(500) + 50);
            etiquettes[i].updatePosition(nodes[i].getX(), nodes[i].getY());
        }
        for (int i = 0; i < relations.length; i++) {
            relations[i].updatePosition();
            fleches[i].updatePosition();
        }
        for (Cycle cycle : cycles) cycle.updatePosition();
    }

}

