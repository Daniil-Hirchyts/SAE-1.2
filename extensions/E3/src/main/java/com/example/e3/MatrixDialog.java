package com.example.e3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MatrixDialog extends Application {

    public static int numElements;

    public static void show(Stage primaryStage) {

        numElements = GraphDialog.show();

        TableView<ObservableList> table = new TableView<>();
        table.setEditable(true);

        // Création des colonnes du tableau
        for (int i = 0; i < numElements; i++) {
            TableColumn<ObservableList, String> column = new TableColumn<>("" + (i + 1));
            final int index = i;
            column.setStyle("-fx-alignment: CENTER;");
            column.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(index)).asString());
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            column.setOnEditCommit(event -> {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).set(event.getTablePosition().getColumn(), event.getNewValue());
            });
            table.getColumns().add(column);
        }

        // Création des lignes du tableau
        for (int i = 0; i < numElements; i++) {
            ObservableList row = FXCollections.observableArrayList();
            for (int j = 0; j < numElements; j++) {
                row.add("0");
            }
            table.getItems().add(row);
        }

        table.getColumns().forEach(column -> column.setSortable(false));

        // Création du layout principal et ajout du tableau
        VBox vBox = new VBox(table);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(10);

        //Faire des cases de meme taille que les colonnes
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button validateButton = new Button("Valider");
        //Recuperer la matrice
        validateButton.setOnAction(event -> {
            int[][] matrix = new int[numElements][numElements];
            for (int i = 0; i < numElements; i++) {
                for (int j = 0; j < numElements; j++) {
                    matrix[i][j] = Integer.parseInt(table.getItems().get(i).get(j).toString());
                }
            }
            GraphView.show(primaryStage, matrix);
            event.consume();
        });

        Button cancelButton = new Button("Reinitialiser");

        HBox hBox = new HBox(cancelButton, validateButton);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setStyle("-fx-alignment: center;");
        vBox.getChildren().add(hBox);
        //faire la taille de bouton de meme taille
        validateButton.prefWidthProperty().bind(Bindings.max(cancelButton.widthProperty(), validateButton.widthProperty()));
        table.setFixedCellSize(30);
        table.prefHeightProperty().bind(table.fixedCellSizeProperty().multiply(Bindings.size(table.getItems()).add(1.01)));
        table.minHeightProperty().bind(table.prefHeightProperty());
        table.maxHeightProperty().bind(table.prefHeightProperty());

        primaryStage.setScene(new Scene(vBox));
        primaryStage.setTitle("Matrice d'adjacence");
        primaryStage.show();

//        primaryStage.setOnCloseRequest(event -> {
//            GraphView.show(primaryStage);
//            event.consume();
//        });
    }

    @Override
    public void start(Stage stage) throws Exception {
    }
}


