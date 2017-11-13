package de.paluno.ledboard.tetris.loop;

import de.paluno.ledboard.tetris.drawing.DrawSystem;
import de.paluno.ledboard.tetris.objects.RowCollapseManager;
import de.paluno.ledboard.tetris.objects.collision.CollisionHandler;

public class TickSystem {

    private CollisionHandler collisionHandler;
    private DrawSystem drawSystem;
    private RowCollapseManager rowCollapseManager;

    public TickSystem(CollisionHandler collisionHandler, DrawSystem drawSystem, RowCollapseManager rowCollapseManager) {
        this.collisionHandler = collisionHandler;
        this.drawSystem = drawSystem;
        this.rowCollapseManager = rowCollapseManager;
    }

    public void tick() {
        if (!collisionHandler.hasMovingPiece()) collisionHandler.addRandomBody();
        collisionHandler.calculateGravity();
        rowCollapseManager.computeCollapses();
        drawSystem.draw();
    }
}
