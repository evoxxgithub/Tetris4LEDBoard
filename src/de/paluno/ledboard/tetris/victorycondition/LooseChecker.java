package de.paluno.ledboard.tetris.victorycondition;

import de.paluno.ledboard.tetris.objects.collision.CollisionHandler;
import de.paluno.ledboard.tetris.objects.collision.GameBoard;

public class LooseChecker {

    private final CollisionHandler collisionHandler;

    public LooseChecker(CollisionHandler  collisionHandler) {
        this.collisionHandler = collisionHandler;
    }

    public boolean gameIsLost(){
        return collisionHandler.getBodies().stream().anyMatch(body ->
            (!body.canMoveDown()) && (body.getCells().stream().anyMatch(cell -> cell.getY() < 4)));
    }


}
