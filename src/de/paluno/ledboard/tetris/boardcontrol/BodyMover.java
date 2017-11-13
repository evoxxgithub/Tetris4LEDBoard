package de.paluno.ledboard.tetris.boardcontrol;

import de.paluno.ledboard.tetris.keyboard.KeyBoard;
import de.paluno.ledboard.tetris.objects.collision.Body;
import de.paluno.ledboard.tetris.objects.collision.Direction;

public class BodyMover {

    private final KeyBoard gameKeyBoard;

    public BodyMover(KeyBoard gameKeyBoard) {
        this.gameKeyBoard = gameKeyBoard;
    }

    void moveIfPossible(Body bodyToMove, Direction directionToMoveTo) {
        int x = directionToMoveTo.getChangingX();
        int y = directionToMoveTo.getChangingY();

        bodyToMove.moveByIfPossible(x,y);
    }

    public void turnIfPossible(Body currentBody, Direction direction) {
        currentBody.turnIfPossible(direction);
    }
}
