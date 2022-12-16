package com.example.game2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSceneTest {

    @Test
    void setN() {
        GameScene.setN(5);
    }

    @Test
    void getLENGTH() {
        GameScene.setN(5);
        assertEquals(128,GameScene.getLENGTH());
    }
}