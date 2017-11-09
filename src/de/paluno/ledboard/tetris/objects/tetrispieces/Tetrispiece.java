package de.paluno.ledboard.tetris.objects.tetrispieces;

import de.paluno.ledboard.tetris.objects.collision.Body;

public class Tetrispiece {

    protected Body body;

    Tetrispiece(Body body) {
        this.body = body;
    }

    public Body getBody(){
        return this.body;
    }
}
