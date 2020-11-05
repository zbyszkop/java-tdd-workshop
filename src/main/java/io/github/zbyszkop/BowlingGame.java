package io.github.zbyszkop;

public class BowlingGame {

    private static final int PIN_NUMBER = 10;

    private boolean lastFrameWasSpare;
    private boolean lastFrameWasStrike;
    private boolean secondToLastFrameWasStrike;
    private int firstRoll = -1;
    private int score = 0;

    public void roll(int pins) {
        if (isFirstRollOfFrame() && pins == 10) {
            if (secondToLastFrameWasStrike) {
                score += 3 * PIN_NUMBER;
            }
            if (lastFrameWasStrike) {
                secondToLastFrameWasStrike = true;
            }
            // Special case: Frame ends in one roll
            lastFrameWasStrike = true;
            return;
        }
        if (isFirstRollOfFrame()) {
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

    private boolean isFirstRollOfFrame() {
          return firstRoll == -1;
    }

    public int getScore() {
        return score;
    }

}
