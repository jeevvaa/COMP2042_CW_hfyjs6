package com.example.game2048;

import javafx.scene.Group;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
Cell c = new Cell(4,6,7,new Group());


    @Test
    void getX() {
        assertEquals(4,c.getX());
    }

    @Test
    void getY() {
        assertEquals(6,c.getY());

    }

    @Test
    void getNumber() {
        assertEquals(0,c.getNumber());
    }
}