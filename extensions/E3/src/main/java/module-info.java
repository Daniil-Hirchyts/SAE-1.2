module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports application;
    opens application to javafx.fxml;
}