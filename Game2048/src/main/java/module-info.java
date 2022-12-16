module com.example.game2048 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.example.game2048 to javafx.fxml;
    exports com.example.game2048;
}