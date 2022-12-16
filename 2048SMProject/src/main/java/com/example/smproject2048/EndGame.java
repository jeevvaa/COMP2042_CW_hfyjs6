package com.example.smproject2048;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;


public class EndGame {
    private static EndGame singleInstance = null;

    private EndGame() {

    }

    public static EndGame getInstance() {
        if (singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }

    public void endGameShow(Color color, Group root, Stage primaryStage, long score) {

        Text text = new Text("GAME OVER");
        text.relocate(200, 200);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Text scoreText = new Text(score + "");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(350, 300);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100, 30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.setFont(Font.font(20));
        quitButton.relocate(500, 500);
        Button restartBtn = new Button("RESTART");
        restartBtn.setPrefSize(150, 30);
        restartBtn.setTextFill(Color.BLACK);
        root.getChildren().add(restartBtn);
        restartBtn.setFont(Font.font(20));
        restartBtn.relocate(300, 500);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    root.getChildren().clear();
                    Platform.exit();
                }
            }
        });
        restartBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Start Dialog");
                alert.setHeaderText("Restart the game");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    root.getChildren().clear();
                    Main m = new Main(color);
                    primaryStage.close();
                    m.start(new Stage());

                }
            }
        });
    }
}
