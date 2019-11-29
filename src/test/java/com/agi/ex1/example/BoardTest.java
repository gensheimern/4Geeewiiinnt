package com.agi.ex1.example;

import org.junit.jupiter.api.Test;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {


    @Test
    void test_1() {
        FourWins fw = FourWins.getSingleton(7,6);
        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_HorizontalCheck() {
        FourWins fw = FourWins.getSingleton(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.O,2);

        //left
        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 3));
        fw.clearBoard();

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.O,3);
        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O,4));
        fw.clearBoard();

        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O, 8));

    }

}
