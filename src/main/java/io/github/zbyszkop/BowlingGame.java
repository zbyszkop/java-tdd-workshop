package io.github.zbyszkop;

public class BowlingGame {

    private int firstRoll = -1;
    private int score = 0;
    public void roll(int pins) {
        if (firstRoll == -1) {
            firstRoll = pins;
        } else {
            score += firstRoll + pins;
        }
    }

    public int getScore() {
        return score;
    }

}
