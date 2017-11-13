package de.paluno.ledboard.tetris.objects.collision;

import de.paluno.ledboard.tetris.boardcontrol.BoardModifier;
import de.paluno.ledboard.tetris.drawing.Color;
import de.paluno.ledboard.tetris.drawing.DrawSystem;
import de.paluno.ledboard.tetris.drawing.Drawable;

public class Cell implements Drawable, Collidable {

    private int x, y;
    Color color;
    private GameBoard board;
    private DrawSystem drawSystem;
    private CollisionHandler collisionHandler;

    public Cell(int x, int y, DrawSystem drawSys, CollisionHandler collisionHandler, Color color, GameBoard board) {
        assert !board.isOccupied(x,y);
        this.color = color;
        this.x = x;
        this.y = y;
        this.drawSystem = drawSys;
        this.collisionHandler = collisionHandler;
        this.board = board;
        board.occupy(x,y);
        this.drawSystem.registerDrawable(this);
    }

    void moveTo(int x, int y){
        board.free(this.x, this.y);
        this.x = x;
        this.y = y;
        board.occupy(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(BoardModifier boardModifier) {
        if ( this.y -4 >= 0) boardModifier.setCell( x, y-4, color.getRed(), color.getGreen(), color.getBlue());
    }

    public boolean canMoveDown(){
       return this.y < 15 && !board.isOccupied(this.x, this.y+1);
    }

    public boolean canMoveLeft(){
        return this.x > 0 && !board.isOccupied(this.x-1, this.y);
    }
    public boolean canMoveRight() {
        return this.x < 15 && !board.isOccupied(this.x+1, this.y);
    }

    public void applyGravity() {
        if (this.canMoveDown()) this.moveTo(this.x, this.y+1);
    }

    public void removeSelf() {

        board.free(this.x, this.y);
        drawSystem.removeDrawable(this);
        collisionHandler.removeCell(this);
    }
}
