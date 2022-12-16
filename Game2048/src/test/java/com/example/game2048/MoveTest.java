package com.example.game2048;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
Move m = new Move(5,new Cell[5][5]);
    @Test
    void getN() {
        assertEquals(5,m.getN());
    }


}