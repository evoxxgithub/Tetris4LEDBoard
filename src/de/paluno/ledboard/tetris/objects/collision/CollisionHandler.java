package de.paluno.ledboard.tetris.objects.collision;

import de.paluno.ledboard.tetris.globalconstants.Constants;
import de.paluno.ledboard.tetris.objects.tetrispieces.Piecefactory;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler {

    private final List<Cell> cellList;
    private final List<Body> movingBodies;
    private final GameBoard board;
    private final Piecefactory piecefactory;
    private final CellComparator comparator;

    public CollisionHandler(GameBoard board, Piecefactory piecefactory) {
        this.cellList = new ArrayList<>();
        this.movingBodies = new ArrayList<>();
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

    public void removeRow(int rowToRemove){

        // remove all loose cells in destroyed row
        List<Cell> cellstoDelete = new ArrayList<>();
        for (Cell cell : this.cellList) {
           if (cell.getY() == rowToRemove) cellstoDelete.add(cell);
        }
        for (Cell cell : cellstoDelete) {
            cell.removeSelf();
        }

        // shatter all bodies that are within the destroyed row
        for (Body movingBody : this.movingBodies) {
            if (movingBody.getCells().stream().anyMatch(cell -> cell.getY() == rowToRemove))
                shatterBody(movingBody, rowToRemove);
        }
    }

    public void addRandomBody(){
        this.movingBodies.add(this.piecefactory.createNewRandomPiece().getBody());
    }

    public void shatterBody(Body bodyToShatter, int rowappliedto){
        List<Cell> cellsToRemove = new ArrayList<>();
        List<Cell> cellsToLeaveLoose = new ArrayList<>();
        for (Cell cell : bodyToShatter.getCells()) {
            if (cell.getY() == rowappliedto) { cellsToRemove.add(cell); }
            else {
                cellsToLeaveLoose.add(cell);
            }
        }
        for (Cell cell : cellsToRemove) {
            bodyToShatter.removeCell(cell);
        }
        for (Cell cell : cellsToLeaveLoose) {
            bodyToShatter.removeCell(cell);
            this.cellList.add(cell);
        }
    }

    public void calculateGravity(){
        for (Cell cell : cellList) {
            cell.applyGravity();
        }
        for (Body movingBody : this.movingBodies) {
            movingBody.applyGravity();
        }
        this.cellList.sort(this.comparator);
    }

    public List<Integer> getAllCollapsingRows(){
        List<Integer> collapsingRowsList = new ArrayList<>();
        for (int y = 0; y < Constants.BOARDWIDTH; y++){
            boolean full = true;
            for (int x = 0; x < Constants.BOARDWIDTH; x++){
                if (!board.isOccupied(x,y)) { full = false; break; }
            }
            if (full) collapsingRowsList.add(y);
        }
        return collapsingRowsList;
    }
    public boolean hasBody() {
        return this.movingBodies.isEmpty();
    }

    public boolean hasMovingPiece() {
        return this.movingBodies.stream().anyMatch(body -> body.canMoveDown());
    }

    public List<Body> getBodies() {
        return this.movingBodies;
    }
}
