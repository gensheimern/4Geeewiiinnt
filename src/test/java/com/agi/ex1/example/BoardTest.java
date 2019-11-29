package com.agi.ex1.example;

import org.junit.jupiter.api.Test;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {


    @Test
    void test_PlaceChip() {
        FourWins fw = new FourWins(7,6);
        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_WrongColumnError(){
        FourWins fw = new FourWins(7,6);

        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O,8));

    }

    @Test
    void test_HorizontalCheckWin() {
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.O,2);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 3));

    }
    @Test
    void test_HorizontalCheckOther(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.O,3);

        assertEquals(Ergebnis.OTHER, fw.throwChip(Player.O,4));
    }

    @Test
    void test_VerticalWinCheck(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,0);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O,0));
    }

    @Test
    void test_DiagonalWinCheck(){

        //Von Links nach Rechts
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.O,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);

        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,2);
        fw.throwChip(Player.X,3);

        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O,3));


        /*
        ====================================================================================================
         */


        //Von Rechts nach Links

        FourWins fw2 = new FourWins(7,6);

        fw2.throwChip(Player.X, 0);
        fw2.throwChip(Player.X, 1);
        fw2.throwChip(Player.X, 2);
        fw2.throwChip(Player.O, 3);

        fw2.throwChip(Player.X, 0);
        fw2.throwChip(Player.X, 1);
        fw2.throwChip(Player.O, 2);

        fw2.throwChip(Player.X, 0);
        fw2.throwChip(Player.O, 1);
        
        assertEquals(Ergebnis.WIN, fw2.throwChip(Player.O,0));


        FourWins fw3 = new FourWins(7,6);


        fw3.throwChip(Player.O,6);
        fw3.throwChip(Player.X,5);
        fw3.throwChip(Player.X,4);
        fw3.throwChip(Player.X,3);

        fw3.throwChip(Player.O,5);
        fw3.throwChip(Player.X,4);
        fw3.throwChip(Player.X,3);

        fw3.throwChip(Player.O,4);
        fw3.throwChip(Player.X,3);





        assertEquals(Ergebnis.WIN, fw3.throwChip(Player.O,3));




    }
}
