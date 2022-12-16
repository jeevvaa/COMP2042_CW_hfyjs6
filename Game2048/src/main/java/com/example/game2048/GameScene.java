package com.example.game2048;


import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.Instant;
import java.util.Random;

class GameScene {
    private static int HEIGHT = 700;
    private static int n = 4;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private final Instant start;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private Cell[][] cells = new Cell[n][n];
    private Group root;
    //  private long score = 0;
    private long bestScore = 0;

    private Color color;

    public GameScene(Color color) {
        this.color = color;
        //start time
        start = Instant.now();
    }

    static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    static double getLENGTH() {
        return LENGTH;
    }

    private void randomFillNumber(int turn) {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound = 0, bForBound = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n - 1) {
                        bForBound = b;
                        b++;

                    } else {
                        aForBound = a;
                        a++;
                        b = 0;
                        if (a == n)
                            break outer;
                    }
                }
            }
        }


        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0)
            putTwo = false;
        int xCell, yCell;
        xCell = random.nextInt(aForBound + 1);
        yCell = random.nextInt(bForBound + 1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

    private int haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if (cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }


    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void sumCellNumbersToScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //  if (cells[i][j].getNumber()>2)
                // score += cells[i][j].getNumber();
            }
        }
    }

    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }


        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");


        bestScore = BestScore.BestScore(Cell.score);
        Text bestSc = new Text();
        root.getChildren().add(bestSc);
        bestSc.setText(" Best SCORE :");
        bestSc.setFont(Font.font(30));
        bestSc.relocate(700, 200);
        Text bScoreText = new Text();
        root.getChildren().add(bScoreText);
        bScoreText.relocate(750, 250);
        bScoreText.setFont(Font.font(20));
        bScoreText.setText("" + bestScore);

        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> {
            Platform.runLater(() -> {
                Move move = new Move(n, cells);
                int haveEmptyCell;
                boolean flag = false;
                if (key.getCode() == KeyCode.DOWN) {
                    move.moveDown();
                    GameScene.this.sumCellNumbersToScore();
                    bestScore = BestScore.BestScore(Cell.score);
                    scoreText.setText(Cell.score + "");
                    flag = true;
                } else if (key.getCode() == KeyCode.UP) {
                    move.moveUp();
                    GameScene.this.sumCellNumbersToScore();
                    bestScore = BestScore.BestScore(Cell.score);
                    scoreText.setText(Cell.score + "");
                    flag = true;
                } else if (key.getCode() == KeyCode.LEFT) {
                    move.moveLeft();
                    GameScene.this.sumCellNumbersToScore();
                    bestScore = BestScore.BestScore(Cell.score);
                    scoreText.setText(Cell.score + "");
                    flag = true;
                } else if (key.getCode() == KeyCode.RIGHT) {
                    move.moveRight();
                    GameScene.this.sumCellNumbersToScore();
                    bestScore = BestScore.BestScore(Cell.score);
                    scoreText.setText(Cell.score + "");
                    flag = true;
                } else if (flag) {
                    flag = false;
                }


                haveEmptyCell = GameScene.this.haveEmptyCell();
                if (haveEmptyCell == -1) {
                    if (GameScene.this.canNotMove()) {
                        primaryStage.setScene(endGameScene);

                        EndGame.getInstance().endGameShow(color, endGameRoot, primaryStage, Cell.score);
                        root.getChildren().clear();
                        Cell.score = 0;
                    }
                } else if (haveEmptyCell == 1 && flag)
                    GameScene.this.randomFillNumber(2);

            });
        });
    }
}
