package com.agi.ex1.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FourWinsLogicTest {


    @Test
    void test_PlaceChip() {
        Board fw = new Board(7, 6, 4);
        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_WrongColumnError() {
        Board fw = new Board(7, 6, 4);

        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O, 8));

    }

    @Test
    void test_Draw7x6(){

        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.X,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,2);
        fw.throwChip(Player.O,3);
        fw.throwChip(Player.X,4);
        fw.throwChip(Player.O,5);
        fw.throwChip(Player.X,6);

        fw.throwChip(Player.X,0);
        fw.throwChip(Player.X,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.O,3);
        fw.throwChip(Player.X,4);
        fw.throwChip(Player.X,5);
        fw.throwChip(Player.O,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);
        fw.throwChip(Player.O,4);
        fw.throwChip(Player.X,5);
        fw.throwChip(Player.O,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,2);
        fw.throwChip(Player.X,3);
        fw.throwChip(Player.O,4);
        fw.throwChip(Player.O,5);
        fw.throwChip(Player.X,6);

        fw.throwChip(Player.X,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,2);
        fw.throwChip(Player.O,3);
        fw.throwChip(Player.X,4);
        fw.throwChip(Player.O,5);
        fw.throwChip(Player.X,6);

        fw.throwChip(Player.X,0);
        fw.throwChip(Player.X,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.O,3);
        fw.throwChip(Player.X,4);
        fw.throwChip(Player.X,5);

        assertEquals(Ergebnis.DRAW,fw.throwChip(Player.O,6));
    }


    @Test
    void test_HorizontalCheckWin() {
        Board fw = new Board(7, 6, 5);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.O, 3);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 4));

    }

    @Test
    void test_HorizontalCheckOther() {
        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.O, 3);

        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O, 4));
    }

    @Test
    void test_VerticalWinCheck() {
        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 0);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_VerticalCheckOther() {
        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.O, 0);

        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_DiagonalWinCheckLinksObenUntenRechts() {

        //Von Links nach Rechts

        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.X, 3);

        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.X, 3);

        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.X, 3);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 3));


    }

    @Test
    void test_DiagonalWinCheckLinksObenRechtsUnten10x8() {
        Board fw = new Board(10, 8, 5);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.X, 3);

        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.O, 3);

        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.X, 3);
        fw.throwChip(Player.O, 3);

        fw.throwChip(Player.O, 4);
        fw.throwChip(Player.X, 4);
        fw.throwChip(Player.X, 4);
        fw.throwChip(Player.X, 4);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 4));

    }

    @Test
    void test_DiagonalWinCheckRechtsObenLinksUnten() {
        //Von Rechts nach Links

        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.X, 1);
        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.O, 3);

        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.X, 1);
        fw.throwChip(Player.O, 2);

        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.O, 1);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 0));


        //Die Gewinnenden Chips, anders Platziert
        Board fw2 = new Board(7, 6, 4);

        fw2.throwChip(Player.O, 6);
        fw2.throwChip(Player.X, 5);
        fw2.throwChip(Player.X, 4);
        fw2.throwChip(Player.X, 3);

        fw2.throwChip(Player.O, 5);
        fw2.throwChip(Player.X, 4);
        fw2.throwChip(Player.X, 3);

        fw2.throwChip(Player.O, 4);
        fw2.throwChip(Player.X, 3);

        assertEquals(Ergebnis.WIN, fw2.throwChip(Player.O, 3));

    }

    @Test
    void test_DiagonalCheckWinObenRechtsUntenLinks8x10() {
        Board fw = new Board(8, 10, 5);

        fw.throwChip(Player.O, 4);
        fw.throwChip(Player.X, 4);

        fw.throwChip(Player.O, 3);
        fw.throwChip(Player.O, 3);
        fw.throwChip(Player.X, 3);


        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.X, 2);

        fw.throwChip(Player.X, 1);
        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.X, 1);
        fw.throwChip(Player.X, 1);
        fw.throwChip(Player.X, 1);

        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.X, 0);
        fw.throwChip(Player.X, 0);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.X, 3));

    }

    @Test
    void test_DiagonalCheckOther() {

        Board fw = new Board(7, 6, 4);

        fw.throwChip(Player.O, 0);
        fw.throwChip(Player.X, 1);
        fw.throwChip(Player.O, 2);
        fw.throwChip(Player.X, 3);

        fw.throwChip(Player.O, 1);
        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.O, 3);

        fw.throwChip(Player.X, 2);
        fw.throwChip(Player.O, 3);

        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O, 3));

    }
}
