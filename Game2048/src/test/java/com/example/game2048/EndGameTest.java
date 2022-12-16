package com.example.game2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndGameTest {

    @Test
    void getInstance() {
        assertEquals( EndGame.getInstance(),EndGame.getInstance());
    }
}