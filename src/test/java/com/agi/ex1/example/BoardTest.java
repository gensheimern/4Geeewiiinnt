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

        /*
        // DAS HIER FUNKTIONIERT
        fw2.throwChip(Player.X, 0);
        fw2.throwChip(Player.X, 1);
        fw2.throwChip(Player.X, 2);
        fw2.throwChip(Player.O, 3);

        fw2.throwChip(Player.X, 0);
        fw2.throwChip(Player.X, 1);
        fw2.throwChip(Player.O, 2);

        fw2.throwChip(Player.X, 0);
        fw2.throwChip(Player.O, 1);

         */

        // DAS HIER FUNKTIONIERT NICHT!??!?!?!?!?!?!?!
        fw2.throwChip(Player.O,6);
        fw2.throwChip(Player.X,5);
        fw2.throwChip(Player.X,4);
        fw2.throwChip(Player.X,3);

        fw2.throwChip(Player.O,5);
        fw2.throwChip(Player.X,4);
        fw2.throwChip(Player.X,3);

        fw2.throwChip(Player.O,4);
        fw2.throwChip(Player.X,3);


        //FÜr die Ausgabe in der Konsole
        System.out.print(" \t\t0 \t\t1 \t\t 2 \t\t 3 \t\t 4 \t\t 5 \t\t 6");
        System.out.println();
        for (int i = 0; i < 6 ; i++) {
            System.out.print(i + "\t|\t");
            for (int j = 0; j <7 ; j++) {
                if(fw2.board[j][i] == null){
                    System.out.print(" " + "\t\t");

                } else {
                    System.out.print(fw2.board[j][i] + "\t\t");
                }
            }
            System.out.println();
        }


        assertEquals(Ergebnis.WIN, fw2.throwChip(Player.O,3));




    }
}
