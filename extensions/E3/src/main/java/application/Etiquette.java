package application;

import javafx.scene.control.Label;

public class Etiquette {
    private Label etiquette;
    private double x;
    private double y;

    public Etiquette(Label etiquette, double x, double y) {
        this.etiquette = etiquette;
        this.x = x;
        this.y = y;
        etiquette.setLayoutX(x - 5);
        etiquette.setLayoutY(y - 7);
    }

    public Label getEtiquette() {
        return etiquette;
    }

    public void updatePosition(double x, double y) {
        this.x = x;
        this.y = y;
        etiquette.setLayoutX(x - 5);
        etiquette.setLayoutY(y - 7);
    }

}
