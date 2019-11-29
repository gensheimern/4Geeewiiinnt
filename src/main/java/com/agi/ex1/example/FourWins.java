package com.agi.ex1.example;

public class FourWins implements FourWinsLogic{

    int xLength;
    int yLength;
    Player[][] board;
    private static FourWins instance;

    private FourWins(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        board = new Player[xLength][yLength];
    }

    public static FourWins getSingleton(int xLength, int yLength){
        if(FourWins.instance == null){
            FourWins.instance = new FourWins(xLength, yLength);
        }
        return FourWins.instance;
    }


    @Override
    public Ergebnis throwChip(Player p, int column) {

        if(column >6 || column <0){
            return Ergebnis.ERROR;
        }

        if(isFree(column)){
            place(p, column);
            return Ergebnis.OTHER;
        }

        return Ergebnis.ERROR;
    }





    private boolean isBoardFull() {
        for (int i = 0; i < xLength-1; i++) {
            if(board[i][yLength-1] == null){
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

        for (int i = 0; i < xLength-1; i++) {
            if(board[column][i] == null){
                return i;
            }
        }
        return 0;
    }


    public boolean isFree(int column){
        if(board[column][yLength-1] == null){
            return true;
        }
        return false;
    }

    public void clearBoard(){
        for (Player[] p : board){
            for (Player p2: p){
                p2 = null;
                }
            }
        }
    }

