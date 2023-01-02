package com.example.e3;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class GraphDialog {
    public static int show() {
        TextInputDialog dialog = new TextInputDialog("4");
        dialog.setTitle("Création d'un nouveau graphe");
        dialog.setHeaderText("Entrez le nombre de noeuds du graphe :");
        Optional<String> result = dialog.showAndWait();
        return result.map(Integer::parseInt).orElse(0);
    }
}
