package de.paluno.ledboard.tetris.objects.collision;

import java.util.List;

public class Body implements Collidable{


    private final Cell anchor;
    private final List<Cell> cells;
    private final CellComparator comparator;

    public Body(Cell anchor, List<Cell> cells) {
        this.comparator = new CellComparator();
        this.anchor = anchor;
        this.cells = cells;
    }

    List<Cell> getCells() {
        return cells;
    }

    public boolean canMoveDown(){
        return this.cells.stream().allMatch(c -> {
            boolean canMoveDown = c.canMoveDown() || cellBelowBelongsToBody(c);
        return canMoveDown;
        });
    }

    private boolean cellBelowBelongsToBody(Cell c) {
        return this.cells.stream().anyMatch(bottomcell ->
            bottomcell.getX() == c.getX() && bottomcell.getY()-1 == c.getY());
    }

    private void moveDown(){
        this.cells.sort(comparator);
        for (Cell cell : this.cells) {
            cell.applyGravity();
        }
    }

    public void turn(Direction direction){
        switch (direction){
            case LEFT:
                System.out.println(""); break;
            case RIGHT:
                System.out.println(""); break;
            default: throw new RuntimeException("unexpected Turndirection input");
        }
        this.cells.sort(this.comparator);
    }


    public void applyGravity() {
        if (canMoveDown()) moveDown();
    }
}
