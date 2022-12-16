package com.example.smproject2048;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StartGame extends Application {


    // launch the application
    public void start(Stage stage) throws IOException {
        // set title for the stage
        stage.setTitle("GAME 2048");

        // create a stack pane
        Group r = new Group();
        Pane pane = new Pane(r);

        //Create game label
        Text text = new Text("Game 2048");
        text.setStyle("-fx-fill: black;-fx-font-weight: bold;");
        text.setFont(Font.font(60));
        text.relocate(250, 200);
        r.getChildren().add(text);

        //color/theme picker
        ColorPicker cp = new ColorPicker(color);
        cp.relocate(350, 300);
        r.getChildren().add(cp);

        // create a button
        Button b = new Button("Start");
        b.setFont(Font.font(20));
        b.setStyle("-fx-background-color: green;-fx-text-fill: white;-fx-min-width: 200px;");
        // add button
        r.getChildren().add(b);


        //background color
        pane.setStyle("-fx-background-color: yellow;");
        b.relocate(300, 400);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                r.getChildren().clear();
                Main m = new Main(cp.getValue());
                stage.close();
                m.start(new Stage());
            }
        };

        // when start button is pressed
        b.setOnAction(event);

        // create a scene
        Scene sc = new Scene(pane, 900, 900);
        sc.fillProperty().bind(cp.valueProperty());
        // set the scene
        stage.setScene(sc);

        stage.show();
    }

    private static Color color;

    public static void main(String args[]) {
        color = Color.YELLOW;
        // launch the application
        launch(args);
    }
}
