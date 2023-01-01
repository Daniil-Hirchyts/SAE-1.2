module com.example.e3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.e3 to javafx.fxml;
    exports com.example.e3;
}