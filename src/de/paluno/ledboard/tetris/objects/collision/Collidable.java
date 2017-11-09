package de.paluno.ledboard.tetris.objects.collision;

public interface Collidable {

    boolean canMoveDown();
    void applyGravity();
}
