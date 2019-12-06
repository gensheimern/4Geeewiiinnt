package com.agi.ex1.example;

import com.agi.ex1.example.*;
import org.junit.jupiter.api.Test;
import sun.util.xml.PlatformXmlPropertiesProvider;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TicTacToeLogicTest {

    @Test
    void test_PlaceChip() {
        Board ttt = new Board(3, 3, 3);
        assertEquals(Ergebnis.OTHER, ttt.setChip(Player.O, 0, 0));
    }

    @Test
    void test_WrongColumnError() {
        Board ttt = new Board(3, 3, 3);
        assertEquals(Ergebnis.ERROR, ttt.setChip(Player.O, 8, 8));
    }

    @Test
    void test_HorizontalCheckWin() {
        Board ttt = new Board(3, 3, 3);

        ttt.setChip(Player.O, 0, 0);
        ttt.setChip(Player.O, 1, 0);

        assertEquals(Ergebnis.WIN, ttt.setChip(Player.O, 2, 0));

    }

    @Test
    void test_HorizontalCheckWin5x5() {
        Board ttt = new Board(5, 5, 5);

        ttt.setChip(Player.O, 0, 0);
        ttt.setChip(Player.O, 1, 0);
        ttt.setChip(Player.O, 2, 0);
        ttt.setChip(Player.O, 3, 0);

        assertEquals(Ergebnis.WIN, ttt.setChip(Player.O, 4, 0));

    }

    @Test
    void test_HorizontalCheckOther() {
        Board fw = new Board(3, 3, 3);

        fw.setChip(Player.O, 0, 0);
        fw.setChip(Player.O, 1, 0);

        assertEquals(Ergebnis.OTHER, fw.setChip(Player.O, 2, 1));
    }

    @Test
    void test_VerticalCheckWin() {
        Board ttt = new Board(3, 3, 3);

        ttt.setChip(Player.O, 0, 0);
        ttt.setChip(Player.O, 0, 1);

        assertEquals(Ergebnis.WIN, ttt.setChip(Player.O, 0, 2));
    }

    @Test
    void test_VerticalCheckOther() {
        Board ttt = new Board(3, 3, 3);

        ttt.setChip(Player.O, 0, 0);
        ttt.setChip(Player.O, 0, 1);

        assertEquals(Ergebnis.OTHER, ttt.setChip(Player.O, 1, 1));
    }

    @Test
    void test_VerticalCheckWin4x4() {
        Board ttt = new Board(4, 4, 4);

        ttt.setChip(Player.O, 0, 0);
        ttt.setChip(Player.O, 0, 1);
        ttt.setChip(Player.O, 0, 2);

        assertEquals(Ergebnis.WIN, ttt.setChip(Player.O, 0, 3));

    }

    @Test
    void test_VerticalCheckOther4x4() {
        Board ttt = new Board(4, 4, 4);

        ttt.setChip(Player.O, 0, 0);
        ttt.setChip(Player.O, 0, 1);
        ttt.setChip(Player.O, 0, 2);

        assertEquals(Ergebnis.OTHER, ttt.setChip(Player.X, 1, 3));
    }

    @Test
    void test_DiagonalCheckWinLinksObenRechtsUnten() {
        Board ttt = new Board(3, 3, 3);

        ttt.setChip(Player.X, 0, 0);
        ttt.setChip(Player.X, 1, 1);

        assertEquals(Ergebnis.WIN, ttt.setChip(Player.X, 2, 2));
    }

    @Test
    void test_DiagonalCheckWinRechtsObenLinksUnten() {
        Board ttt = new Board(3, 3, 3);

        ttt.setChip(Player.X, 2, 0);
        ttt.setChip(Player.X, 1, 1);

        assertEquals(Ergebnis.WIN, ttt.setChip(Player.X, 0, 2));
    }


}
