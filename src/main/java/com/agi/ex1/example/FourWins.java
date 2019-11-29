package com.agi.ex1.example;

import com.agi.ex1.example.FourWinsLogic;

public class FourWins implements FourWinsLogic {

    int xLength;
    int yLength;
    Player[][] board;

    public FourWins(int xLength, int yLength) {
        this.xLength = xLength-1;
        this.yLength = yLength-1;
        board = new Player[xLength][yLength];
    }


    @Override
    public Ergebnis throwChip(Player p, int column) {

        if(column >6 || column <0){
            return Ergebnis.ERROR;
        }

        if(isFree(column)){
            place(p, column);
        }

        if(checkWinHorizontal()){
            return Ergebnis.WIN;
        } else if (checkWinVertical()) {
            return Ergebnis.WIN;
        } else if (checkWinDiagonal()) {
            return Ergebnis.WIN;
        } else {
            return Ergebnis.OTHER;
        }
    }

    public boolean checkWinHorizontal(){

        Player chip1, chip2, chip3, chip4;
        for (int i = 0; i < yLength ; i++) {
            for (int j = 0; j < xLength-2 ; j++) {
                chip1 = board[j][i];
                chip2 = board[j+1][i];
                chip3 = board[j+2][i];
                chip4 = board[j+3][i];

                if(chip1 == chip2 && chip2 == chip3 && chip3== chip4 && chip1 != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinDiagonal(){

        Player chip1, chip2, chip3, chip4;

        //Überprüft ob der Spieler Diagonal gewonnen hat von Oben links nach unten rechts
        for (int i = 0; i < yLength-3 ; i++) {
            for (int j = 0; j < xLength-3 ; j++) {
                chip1 = board[j][i];
                chip2 = board[j+1][i+1];
                chip3 = board[j+2][i+2];
                chip4 = board[j+3][i+3];

                if(chip1 == chip2 && chip2 == chip3 && chip3== chip4 && chip1 != null) {
                    return true;
                }
            }
        }

        //Überprüft ob der Spieler Diagonal gewonnen hat von Oben rechts nach unten links
        for (int i = 0; i < yLength-2 ; i++) {
            for (int j = xLength-3; j < xLength ; j++) {
                chip1 = board[j][i];
                chip2 = board[j-1][i+1];
                chip3 = board[j-2][i+2];
                chip4 = board[j-3][i+3];


            //    System.out.println(chip1 + " " + chip2 + " " + chip3 + " " + chip4);

                if(chip1 == chip2 && chip2 == chip3 && chip3== chip4 && chip1 != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinVertical(){
        Player chip1, chip2, chip3, chip4;
        for (int i = 0; i < yLength-2 ; i++) {
            for (int j = 0; j < xLength ; j++) {
                chip1 = board[j][i];
                chip2 = board[j][i+1];
                chip3 = board[j][i+2];
                chip4 = board[j][i+3];

                if(chip1 == chip2 && chip2 == chip3 && chip3== chip4 && chip1 != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < xLength; i++) {
            if(board[i][yLength] == null){
                return false;
            }
        }
        return true;
    }


    public int[] place(Player p, int column){

        int[] pos = new int[2];
        int y = checkRowInBoard(column);

        board[column][y] = p;
        pos[0] = column;
        pos[1] = y;


        return pos;
    }

    private int checkRowInBoard(int column) {

        for (int i = 0; i < xLength; i++) {
            if(board[column][i] == null){
                return i;
            }
        }
        return 0;
    }


    public boolean isFree(int column){
        if(board[column][yLength] == null){
            return true;
        }
        return false;
    }

    }

