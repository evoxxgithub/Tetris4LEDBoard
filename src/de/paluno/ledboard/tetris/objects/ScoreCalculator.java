package de.paluno.ledboard.tetris.objects;

public class ScoreCalculator {

    private int score;

    public ScoreCalculator() {
        this.score = 0;
    }

    public void addScore(int addedScore) {
        this.score += addedScore;
    }
}
