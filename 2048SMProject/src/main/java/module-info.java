module com.example.smproject2048 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.smproject2048 to javafx.fxml;
    exports com.example.smproject2048;
}