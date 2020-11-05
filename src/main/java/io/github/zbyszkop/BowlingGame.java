package io.github.zbyszkop;

public class BowlingGame {

    private static final int SPARE_SCORE = 10;
    private boolean lastFrameWasSpare;
    private int firstRoll = -1;
    private int score = 0;

    public void roll(int pins) {
        if (firstRoll == -1) {
            firstRoll = pins;
            if (lastFrameWasSpare) {
                score += SPARE_SCORE + firstRoll;
                lastFrameWasSpare = false;
            }
        } else {
            if (firstRoll + pins == SPARE_SCORE) {
                lastFrameWasSpare = true;
            }
            else {
                score += firstRoll + pins;
            }
            firstRoll = -1;
        }
    }

    public int getScore() {
        return score;
    }

}
