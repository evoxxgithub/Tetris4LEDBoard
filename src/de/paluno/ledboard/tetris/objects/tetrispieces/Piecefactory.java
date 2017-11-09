package de.paluno.ledboard.tetris.objects.tetrispieces;

import de.paluno.ledboard.tetris.drawing.Color;
import de.paluno.ledboard.tetris.drawing.DrawSystem;
import de.paluno.ledboard.tetris.objects.collision.Cell;
import de.paluno.ledboard.tetris.objects.collision.GameBoard;
import de.paluno.ledboard.tetris.objects.collision.Body;
import de.paluno.ledboard.tetris.objects.collision.CollisionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Piecefactory {

    private Random random;
    private GameBoard board;
    private DrawSystem drawSystem;
    private CollisionHandler collisionHandler;

    public Piecefactory(GameBoard board, DrawSystem drawSystem) {
        this.board = board;
        this.drawSystem = drawSystem;
        this.random = new Random();
    }

    public void setCollisionHandler(CollisionHandler collisionHandler){
        this.collisionHandler = collisionHandler;
    }

    public Tetrispiece createNewRandomPiece(){
        Tetrispiece createdPiece;
        System.out.println("created a piece");
        switch(random.nextInt(5)){
            case 0: createdPiece = createNewI(); break;
            case 1: createdPiece = createNewL(); break;
            case 2: createdPiece = createNewO(); break;
            case 3: createdPiece =  createNewS(); break;
            case 4: createdPiece =  createNewT(); break;
            default: throw new RuntimeException("Unkown Tetrispiecetype wished to create");
        }
        return createdPiece;
    }

    private Tetrispiece createNewT() {
        Color tColor = new Color(0,127,0);
        Cell lefttop = new Cell(5,2, drawSystem, collisionHandler, tColor, board);
        Cell middletop = new Cell(6,2, drawSystem, collisionHandler, tColor, board);
        Cell righttop = new Cell(7,2, drawSystem, collisionHandler, tColor, board);
        Cell bottom = new Cell(6,3, drawSystem, collisionHandler, tColor, board);
        List<Cell> cellList = new ArrayList<>();
        cellList.add(lefttop);
        cellList.add(middletop);
        cellList.add(righttop);
        cellList.add(bottom);
        Body body = new Body(middletop, cellList);
        return new T(body);
    }

    private Tetrispiece createNewS() {
        Color sColor = new Color(127,0,0);
        Cell lefttop = new Cell(5,1, drawSystem, collisionHandler, sColor, board);
        Cell leftbot = new Cell(5,2, drawSystem, collisionHandler, sColor, board);
        Cell righttop = new Cell(6,2, drawSystem, collisionHandler, sColor, board);
        Cell rightbot = new Cell(6,3, drawSystem, collisionHandler, sColor, board);
        List<Cell> cellList = new ArrayList<>();
        cellList.add(lefttop);
        cellList.add(leftbot);
        cellList.add(righttop);
        cellList.add(rightbot);
        Body body = new Body(leftbot, cellList);
        return new S(body);
    }

    private Tetrispiece createNewO() {
        Color oColor = new Color(0,0,127);
        Cell lefttop = new Cell(5,2, drawSystem, collisionHandler, oColor, board);
        Cell bottomleft = new Cell(5,3, drawSystem, collisionHandler, oColor, board);
        Cell righttop = new Cell(6,2, drawSystem, collisionHandler, oColor, board);
        Cell bottomright = new Cell(5,3, drawSystem, collisionHandler, oColor, board);
        List<Cell> cellList = new ArrayList<>();
        cellList.add(lefttop);
        cellList.add(bottomleft);
        cellList.add(righttop);
        cellList.add(bottomright);
        Body body = new Body(lefttop, cellList);
        return new O(body);
    }

    private Tetrispiece createNewL() {
        Color lColor = new Color(127,127,127);
        Cell top = new Cell(5,1, drawSystem, collisionHandler, lColor, board);
        Cell middle = new Cell(5,2, drawSystem, collisionHandler, lColor, board);
        Cell bottom = new Cell(5,3, drawSystem, collisionHandler, lColor, board);
        Cell bottomright = new Cell(6,3, drawSystem, collisionHandler, lColor, board);
        List<Cell> cellList = new ArrayList<>();
        cellList.add(top);
        cellList.add(middle);
        cellList.add(bottom);
        cellList.add(bottomright);
        Body body = new Body(middle, cellList);
        return new L(body);
    }

    private Tetrispiece createNewI() {
        Color iColor = new Color(127,127,0);
        Cell toptop = new Cell(5,0, drawSystem, collisionHandler, iColor, board);
        Cell topbottom = new Cell(5,1, drawSystem, collisionHandler, iColor, board);
        Cell bottomtop = new Cell(5,2, drawSystem, collisionHandler, iColor, board);
        Cell bottombottom = new Cell(5,3, drawSystem, collisionHandler, iColor, board);
        List<Cell> cellList = new ArrayList<>();
        cellList.add(toptop);
        cellList.add(topbottom);
        cellList.add(bottomtop);
        cellList.add(bottombottom);
        Body body = new Body(topbottom, cellList);
        return new I(body);
    }
}
