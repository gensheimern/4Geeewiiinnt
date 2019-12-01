package com.agi.ex1.example;

import java.time.Clock;

public class MeineMain {

    public static void main(String[] args) {

        MeineMain mainRandome = new MeineMain();
        mainRandome.playRandomeLoop(50);
//        mainRandome.playRandom();
    }

    private void printField(FourWins fw){

        for (int j = fw.getyLength() ; j >= 0 ; j--) {
            System.out.print((j+1) + "\t|\t");
            for (int k = 0; k <= fw.getxLength() ; k++) {
                if(fw.getBoard()[k][j] == null){
                    System.out.print(" " + "\t|\t");

                } else {
                    System.out.print(fw.getBoard()[k][j] + "\t|\t");
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------------------------");
        }
    }

    public void playRandomeLoop(int iteration){
        for (int i = 0; i < iteration; i++) {
            playRandom();
        }
    }


    public void playRandom(){
        FourWins fw = new FourWins(7,6);

        boolean one = true;
        for (int i = 0; i < 42 ; i++) {
            Ergebnis ergebnis = fw.throwChip(one ? Player.O : Player.X,(int) Math.round(Math.random() * (fw.getxLength())));
            one = !one;
            if(ergebnis == Ergebnis.WIN){
                printField(fw);
                if(one){
                    System.out.println("X HAT GEWONNEN");
                }else {
                    System.out.println("O HAT GEWONNEN");
                }
                return;
            }else if(ergebnis == Ergebnis.ERROR){
                System.out.print("FEHLER von ");
                if(one){
                    System.out.println("X");
                }else {
                    System.out.println("O");
                }
            }
        }
    }
}
