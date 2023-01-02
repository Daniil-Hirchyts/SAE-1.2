module application.extension3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.extension3 to javafx.fxml;
    exports application.extension3;
}