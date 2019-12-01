package com.agi.ex1.example;


public class FourWins implements FourWinsLogic {

    private int xLength;
    private int yLength;
    private Player[][] board;
    private boolean isPlayerOneTurn;
    private boolean isPlayerTwoTurn;


    public FourWins(int xLength, int yLength) {
        this.xLength = xLength-1;
        this.yLength = yLength-1;
        this.isPlayerOneTurn = true;
        this.isPlayerTwoTurn = false;
        board = new Player[xLength][yLength];

    }

    @Override
    public Ergebnis throwChip(Player p, int column) {

        if(checkIfPlayersMove(p)){

        }else {
            return Ergebnis.ERROR;
        }

        //check if param @column is outOfBounds from xLengthMin & xLengthMax
        if(column > getxLength() || column < 0){
            return Ergebnis.ERROR;
        }

        //check if limit of yLength is reached
        if(isFree(column)){
            place(p, column);
        }else {
            return Ergebnis.ERROR;
        }

        if(checkWinHorizontal() || checkWinVertical() || checkWinDiagonal()){
            return Ergebnis.WIN;
        } else {
            if(isBoardFull()){
                return Ergebnis.DRAW;
            }
            return Ergebnis.OPEN;
        }


    }

    public boolean checkIfPlayersMove(Player player){

        if(isPlayerOneTurn && player == Player.O) {
            this.isPlayerOneTurn = false;
            this.isPlayerTwoTurn = true;
            return true;
        }
        else if (isPlayerTwoTurn && player == Player.X){
            this.isPlayerTwoTurn = false;
            this.isPlayerOneTurn = true;
            return true;
        }else {
            return false;
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
            for (int j = xLength-3; j <= xLength ; j++) {
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








    // ================== Getter & Setter ============================================

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    public Player[][] getBoard() {
        return board;
    }

    public void setBoard(Player[][] board) {
        this.board = board;
    }
    public boolean isPlayerOneTurn() {
        return isPlayerOneTurn;
    }

    public void setPlayerOneTurn(boolean playerOneTurn) {
        isPlayerOneTurn = playerOneTurn;
    }

    public boolean isPlayerTwoTurn() {
        return isPlayerTwoTurn;
    }

    public void setPlayerTwoTurn(boolean playerTwoTurn) {
        isPlayerTwoTurn = playerTwoTurn;
    }
}

