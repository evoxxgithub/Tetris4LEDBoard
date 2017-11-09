package de.paluno.ledboard.tetris.objects.collision;

import de.paluno.ledboard.tetris.globalconstants.Constants;
import de.paluno.ledboard.tetris.objects.tetrispieces.Piecefactory;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler {

    private final List<Cell> cellList;
    private Body movingBody;
    private final GameBoard board;
    private final Piecefactory piecefactory;
    private final CellComparator comparator;

    public CollisionHandler(GameBoard board, Piecefactory piecefactory) {
        this.cellList = new ArrayList<>();
        this.board = board;
        this.piecefactory = piecefactory;
        this.comparator = new CellComparator();
    }

    private void registerCell(Cell cell) {
        this.cellList.add(cell);
    }

    void removeCell(Cell cell){
        this.cellList.remove(cell);
    }

    public void removeRow(int y){
        List<Cell> cellstoDelete = new ArrayList<>();
        for (Cell cell : this.cellList) {
           if (cell.getY() == y) cellstoDelete.add(cell);
        }
        for (Cell cell : cellstoDelete) {
            cell.removeSelf();
        }
    }


    //removes old body and adds a new one
    public void fixTetrisPiece(){

        for (Cell cell : movingBody.getCells()) {
            this.registerCell(cell);
        }
        movingBody = null;
    }

    public void addNewBody(){
        this.movingBody = this.piecefactory.createNewRandomPiece().getBody();

    }

    public void calculateGravity(){
        if (movingBody == null)
            addNewBody();
        System.out.println(movingBody.canMoveDown());
        if (!movingBody.canMoveDown()) this.fixTetrisPiece();
        for (Cell cell : cellList) {
            cell.applyGravity();
        }
        if (movingBody != null) movingBody.applyGravity();
        this.cellList.sort(this.comparator);
    }

    public List<Integer> getAllCollapsingRows(){
        List<Integer> collapsingRowsList = new ArrayList<>();
        for (int y = 0; y < Constants.BOARDWIDTH; y++){
            boolean full = true;
            for (int x = 0; x < Constants.BOARDWIDTH; x++){
                if (board.isOccupied(x,y)) { full = false; break; }
            }
            if (full) collapsingRowsList.add(y);
        }
        return collapsingRowsList;
    }

    private void setMovingBody(Body movingBody) {
        this.movingBody = movingBody;
    }

    public boolean hasBody() {
        return this.movingBody != null;
    }
}
