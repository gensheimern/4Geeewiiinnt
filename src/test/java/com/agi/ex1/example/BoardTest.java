package com.agi.ex1.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {


    @Test
    void test_PlaceChip() {
        FourWins fw = new FourWins(7,6);
        assertEquals(Ergebnis.OPEN, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_IsBoardFull(){
        FourWins fw = new FourWins(7,6);

        boolean one = true;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < fw.getxLength() ; j++) {
                fw.throwChip(one ? Player.O : Player.X, j);
                one = !one;
            }
        }
        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O, (int) Math.round(Math.random() * (fw.getxLength()))));
    }

    @Test
    void test_isColumnFull() {
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,0);
        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,0);
        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,0);

        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O, 0));
    }

    @Test
    void test_IsPlayersTurn(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);


        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.X, 1));

    }

    @Test
    void test_WrongColumnError(){
        FourWins fw = new FourWins(7,6);

        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O,8));
        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.O,-1));

    }

    @Test
    void test_CheckIsDraw(){
        FourWins fw = new FourWins(7,6);
        boolean one = true;
        int count  = 0;

        for (int j = 0; j <= fw.getyLength(); j++) {
            for (int i = 0; i <= fw.getxLength() ; i++) {
                if(count == 41){
                    return;
                }
                fw.throwChip(one ? Player.X : Player.O,i);
                one = !one;
                count++;
            }
        }
        assertEquals(Ergebnis.DRAW, fw.throwChip(one ? Player.X : Player.O,7));
    }

    @Test
    void test_HorizontalCheckWin() {
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,0);

        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,0);

        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,0);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O, 3));

        FourWins fw2 = new FourWins(7,6);

        fw2.throwChip(Player.O,0);
        fw2.throwChip(Player.X,0);


    }
    @Test
    void test_HorizontalCheckOpen(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,0);

        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,1);

        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,2);

        assertEquals(Ergebnis.OPEN, fw.throwChip(Player.O,4));
    }

    @Test
    void test_VerticalWinCheck(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.O,0));
    }

    @Test
    void test_VerticalCheckOpen(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);
        fw.throwChip(Player.O,4);

        assertEquals(Ergebnis.OPEN, fw.throwChip(Player.X, 5));
    }

    @Test
    void test_VerticalCheckError(){
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);
        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);
        fw.throwChip(Player.O,4);
        fw.throwChip(Player.X,5);
        fw.throwChip(Player.O,6);

        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.X, 7));
        assertEquals(Ergebnis.ERROR, fw.throwChip(Player.X, -1));

    }

    @Test
    void test_DiagonalWinCheck(){

        //from left to right
        FourWins fw = new FourWins(7,6);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,1);

        fw.throwChip(Player.O,2);
        fw.throwChip(Player.X,3);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,2);

        fw.throwChip(Player.O,1);
        fw.throwChip(Player.X,1);

        fw.throwChip(Player.O,0);
        fw.throwChip(Player.X,3);

        fw.throwChip(Player.O,4);
        fw.throwChip(Player.X,3);

        fw.throwChip(Player.O,4);
        fw.throwChip(Player.X,3);

        fw.throwChip(Player.O,4);

        assertEquals(Ergebnis.WIN, fw.throwChip(Player.X,4));


        /*
        ====================================================================================================
         */

        FourWins fw2 = new FourWins(7,6);


        fw2.throwChip(Player.O,2);
        fw2.throwChip(Player.X,0);

        fw2.throwChip(Player.O,2);
        fw2.throwChip(Player.X,4);

        fw2.throwChip(Player.O,3);
        fw2.throwChip(Player.X,1);

        fw2.throwChip(Player.O,0);
        fw2.throwChip(Player.X,1);

        fw2.throwChip(Player.O,1);
        fw2.throwChip(Player.X,0);

        assertEquals(Ergebnis.WIN, fw2.throwChip(Player.O,0));
    }

    //play Game randome time
    public void playRandomeLoop(int iteration){
        for (int i = 0; i < iteration; i++) {
            playRandom();
        }
    }


    // play game with two Players once
    public void playRandom(){
        FourWins fw = new FourWins(7,6);

        boolean one = true;
        for (int i = 0; i < 42 ; i++) {
            Ergebnis ergebnis = fw.throwChip(one ? Player.O : Player.X,(int) Math.round(Math.random() * (fw.getxLength())));
            one = !one;
            if(ergebnis == Ergebnis.WIN){
                return;
            }
        }
    }
}
