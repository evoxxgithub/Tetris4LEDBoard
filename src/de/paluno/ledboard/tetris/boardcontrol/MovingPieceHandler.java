package de.paluno.ledboard.tetris.boardcontrol;

import de.paluno.ledboard.tetris.keyboard.Key;
import de.paluno.ledboard.tetris.keyboard.KeyBoard;
import de.paluno.ledboard.tetris.objects.collision.Body;
import de.paluno.ledboard.tetris.objects.collision.CollisionHandler;
import de.paluno.ledboard.tetris.objects.collision.Direction;

import java.util.List;

public class MovingPieceHandler {

    private final KeyBoard keyBoard;
    private Body currentBody;
    private final CollisionHandler collisionHandler;
    private final BodyMover bodyMover;

    public MovingPieceHandler(KeyBoard keyBoard, CollisionHandler collisionHandler, BodyMover bodyMover) {
        this.collisionHandler = collisionHandler;
        this.keyBoard = keyBoard;
        this.bodyMover = bodyMover;
    }

    public Body getCurrentBody() {
        return currentBody;
    }

    public void setCurrentBody(Body currentBody) {
        this.currentBody = currentBody;
    }

    public void applyKeyPressesToCurrentBody(){
        List<Key> pressedKeys = keyBoard.deliverPressedKeys();
        for (Key pressedKey : pressedKeys) {
            this.applyPressedKeyToCurrentBody(pressedKey);
        }
    }

    private void applyPressedKeyToCurrentBody(Key pressedKey) {

        switch(pressedKey){

            case _A_: bodyMover.moveIfPossible(this.currentBody, Direction.LEFT);
                break;
            case _S_: bodyMover.moveIfPossible(this.currentBody, Direction.DOWN);
                break;
            case _D_: bodyMover.moveIfPossible(this.currentBody, Direction.RIGHT);
                break;
            case _K_: bodyMover.turnIfPossible(this.currentBody, Direction.LEFT);
                break;
            case _L_: bodyMover.turnIfPossible(this.currentBody, Direction.RIGHT);
                break;
        }
    }


}
