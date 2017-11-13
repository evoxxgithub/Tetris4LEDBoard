package de.paluno.ledboard.tetris.objects.collision;

import de.paluno.ledboard.tetris.globalconstants.Constants;

public class GameBoard {

    private boolean[][] occupiedBoard;

    public GameBoard() {
        occupiedBoard = new boolean[Constants.BOARDWIDTH][Constants.BOARDWIDTHWITHFREESPACE];
    }

    public GameBoard(boolean[][] occupiedBoard) {
        this.occupiedBoard = occupiedBoard;
        for (int i = 0; i < occupiedBoard.length; i++) {
            for (int j = 0; j < occupiedBoard[i].length; j++) {
                occupiedBoard[i][j] = false;
            }
        }
    }

    public void occupy(int x, int y){
        if (x < 0 || y < 0 || x >= Constants.BOARDWIDTH || y >= Constants.BOARDWIDTHWITHFREESPACE)
            throw new RuntimeException("tried to occupy a field out of the boardrange " + x + " " + y);
        this.occupiedBoard[x][y] = true;
    }

    public void free(int x, int y) {
        if (x < 0 || y < 0 || x >= Constants.BOARDWIDTH || y >= Constants.BOARDWIDTHWITHFREESPACE)
            throw new RuntimeException("tried to free a field out of the boardrange");
        this.occupiedBoard[x][y] = false;
    }

    public boolean isOccupied(int x, int y){
        return y < 16 && x < 16 && this.occupiedBoard[x][y];
    }

    public boolean isOccupiedOverScreen() {

        boolean isOccupiedOverScreen = false;
        for (int y = 0;y < 4 && !isOccupiedOverScreen; y++){
            for (int x = 0; x < Constants.BOARDWIDTH && !isOccupiedOverScreen; x++){
                if (this.isOccupied(x, y)) isOccupiedOverScreen = true;
            }
        }
        return isOccupiedOverScreen;
    }
}
