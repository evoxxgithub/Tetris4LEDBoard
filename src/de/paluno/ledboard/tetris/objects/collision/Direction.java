package de.paluno.ledboard.tetris.objects.collision;

public enum
Direction {

    UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    private int changingX, changingY;

    Direction(int changingX, int changingY) {
        this.changingX = changingX;
        this.changingY = changingY;
    }

    public int getChangingX() {
        return changingX;
    }

    public int getChangingY(){
        return changingY;
    }
}
