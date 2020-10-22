package io.github.zbyszkop;

public class BowlingGame {
    private int previousRoll;
    private int score;
    private boolean firstRoll = true;

    public void roll(int pins) {
        if (firstRoll) {
            this.previousRoll = pins;
            firstRoll = false;
        } else {
            this.score += this.previousRoll + pins;
            firstRoll = true;
        }
    }

    public int getScore() {
        return score;
    }
}
