package io.github.zbyszkop;

public class BowlingGame {
    int rollCount = 0;
    int lastPins = 0;
    int score = 0;
    public void roll(int pins) {
        if (isEndofFrame()) {
            score += pins + lastPins;
        }
        lastPins = pins;
        rollCount++;
    }

    private boolean isEndofFrame() {
        return rollCount % 2 == 1;
    }

    public int getScore() {
        return score;
    }
}
