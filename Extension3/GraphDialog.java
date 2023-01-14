package application;

import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class GraphDialog {
    public static int show() {
        TextInputDialog dialog = new TextInputDialog("4");
        dialog.setTitle("Création d'un nouveau graphe");
        dialog.setHeaderText("Entrez la cardinalité d'un graphe :");
        Optional<String> result = dialog.showAndWait();
        return result.map(Integer::parseInt).orElse(0);
    }
}
