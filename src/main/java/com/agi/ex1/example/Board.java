package com.agi.ex1.example;

import java.util.ArrayList;
import java.util.List;

public class Board implements FourWinsLogic, TicTacToeLogic {

    final int X_LENGTH;
    final int Y_LENGTH;
    final int WIN_STREET;
    Player[][] board;

    public Board(int X_LENGTH, int Y_LENGTH, int WIN_STREET) {
        this.X_LENGTH = X_LENGTH - 1;
        this.Y_LENGTH = Y_LENGTH - 1;
        this.WIN_STREET = WIN_STREET;
        board = new Player[X_LENGTH][Y_LENGTH];
    }


    @Override
    public Ergebnis throwChip(Player p, int column) {

        if (column > X_LENGTH || column < 0) {
            return Ergebnis.ERROR;
        }

        if (isFree(column)) {
            place(p, column);
        }

        if (checkWinHorizontal()) {
            return Ergebnis.WIN;
        } else if (checkWinVertical()) {
            return Ergebnis.WIN;
        } else if (checkWinDiagonal()) {
            return Ergebnis.WIN;
        } else {
            return Ergebnis.OTHER;
        }
    }

    @Override
    public Ergebnis setChip(Player p, int column, int row) {

        if (column > X_LENGTH || column < 0) {
            return Ergebnis.ERROR;
        }

        if (isFree(column, row)) {
            place(p, column, row);
        }

        if (checkWinHorizontal()) {
            return Ergebnis.WIN;
        } else if (checkWinVertical()) {
            return Ergebnis.WIN;
        } else if (checkWinDiagonal()) {
            return Ergebnis.WIN;
        } else {
            return Ergebnis.OTHER;
        }
    }

    public boolean checkWinHorizontal() {

        Player[] playerList = new Player[WIN_STREET];
        for (int i = 0; i < Y_LENGTH; i++) {
            for (int j = 0; j <= (WIN_STREET - 1 - X_LENGTH) * (-1); j++) {
                for (int k = 0; k < WIN_STREET; k++) {
                    playerList[k] = board[j + k][i];
                }
                if (winCheckHelper(playerList)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean checkWinDiagonal() {

        Player[] playerList = new Player[WIN_STREET];

        //Überprüft ob der Spieler Diagonal gewonnen hat von Oben links nach unten rechts
        for (int i = 0; i <= (WIN_STREET - 1 - Y_LENGTH) * (-1); i++) {
            for (int j = 0; j <= (WIN_STREET - 1 - X_LENGTH) * (-1); j++) {
                for (int k = 0; k < WIN_STREET; k++) {
                    playerList[k] = board[j + k][i + k];
                }

                if (winCheckHelper(playerList)) {
                    return true;
                }
            }
        }


        //Überprüft ob der Spieler Diagonal gewonnen hat von Oben rechts nach unten links
        for (int i = 0; i <= (WIN_STREET - 1 - Y_LENGTH) * (-1); i++) {
            for (int j = WIN_STREET - 1; j <= X_LENGTH; j++) {
                int k = 0;
                for (; k < WIN_STREET; k++) {
                    playerList[k] = board[j - k][i + k];
                }
                if (k == WIN_STREET) {
                    if (winCheckHelper(playerList)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean checkWinVertical() {

        Player[] playerList = new Player[WIN_STREET];
        for (int i = 0; i <= (WIN_STREET - 1 - Y_LENGTH) * (-1); i++) {
            for (int j = 0; j < X_LENGTH; j++) {
                int k = 0;
                for (; k < WIN_STREET; k++) {

                    playerList[k] = board[j][i + k];
                }

                if (winCheckHelper(playerList)) {
                    return true;

                }
            }
        }
        return false;
    }

    private boolean winCheckHelper(Player[] p) {


        for (int k = 1; k < WIN_STREET; k++) {

            if (p[k - 1] != p[k] || p[k] == null || p[k - 1] == null) {
                return false;
            }
        }
        return true;
    }


    private boolean isBoardFull() {
        for (int i = 0; i < X_LENGTH; i++) {
            if (board[i][Y_LENGTH] == null) {
                return false;
            }
        }
        return true;
    }


    public int[] place(Player p, int column) {

        int[] pos = new int[2];
        int y = checkRowInBoard(column);

        board[column][y] = p;
        pos[0] = column;
        pos[1] = y;


        return pos;
    }

    public int[] place(Player p, int column, int row) {

        int[] pos = new int[2];

        if (board[column][row] == null) {
            board[column][row] = p;
            System.out.println(column + " " + row);
        }
        pos[0] = column;
        pos[1] = row;


        return pos;
    }

    private int checkRowInBoard(int column) {

        for (int i = 0; i < X_LENGTH; i++) {
            if (board[column][i] == null) {
                return i;
            }
        }
        return 0;
    }


    public boolean isFree(int column) {
        if (board[column][Y_LENGTH] == null) {
            return true;
        }
        return false;
    }

    public boolean isFree(int column, int row) {
        if (board[column][row] == null) {
            return true;
        }
        return false;
    }


}

