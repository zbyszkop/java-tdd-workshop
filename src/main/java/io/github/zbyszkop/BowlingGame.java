package io.github.zbyszkop;

public class BowlingGame {

    private static final int PIN_NUMBER = 10;

    private boolean lastFrameWasSpare;
    private boolean lastFrameWasStrike;
    private int firstRoll = -1;
    private int score = 0;

    // TODO: refactor firstRoll == -1 into isFirstRollOfFrame
    public void roll(int pins) {
        if (firstRoll == -1 && pins == 10) {
            // Special case: Frame ends in one roll
            lastFrameWasStrike = true;
            return;
        }
        if (firstRoll == -1) {
            firstRoll = pins;
            if (lastFrameWasSpare) {
                score += PIN_NUMBER + firstRoll;
                lastFrameWasSpare = false;
            }
        } else {
            if (firstRoll + pins == PIN_NUMBER) {
                lastFrameWasSpare = true;
            }
            else {
                if (lastFrameWasStrike) {
                score += firstRoll + pins + PIN_NUMBER;
                lastFrameWasStrike = false;
                }
                score += firstRoll + pins;
            }
            firstRoll = -1;
        }
    }

    public int getScore() {
        return score;
    }

}
