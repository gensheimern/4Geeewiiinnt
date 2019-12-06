package com.agi.ex1.example;

import java.time.Clock;

public class MeineMain {

    public static void main(String[] args) {
        //   FourWins fw = FourWins.getSingleton(7,6);
        FourWins fw = new FourWins(6,7,4);

        fw.throwChip(Player.X,5);
        fw.throwChip(Player.X,6);
        fw.throwChip(Player.X,3);
        fw.throwChip(Player.X,4);

        System.out.print(" \t\t0 \t\t1 \t\t 2 \t\t 3 \t\t 4 \t\t 5 \t\t 6");
        System.out.println();
        for (int i = 0; i < 6 ; i++) {
            System.out.print(i + "\t|\t");
            for (int j = 0; j <7 ; j++) {
                if(fw.board[j][i] == null){
                    System.out.print(" " + "\t\t");

                } else {
                    System.out.print(fw.board[j][i] + "\t\t");
                }
            }
            System.out.println();
    }
        System.out.println(fw.checkWinHorizontal());

    }
}
