package io.github.zbyszkop;

public class BowlingGame {
    int rollCount = 0;
    int lastPins = 0;
    boolean strikeProgress = false;
    int score = 0;
    boolean spare = false;
    boolean strike = false;

    public void roll(int pins) {
        if(strike){
            if(!strikeProgress){
                strikeProgress = true;
            }
            else{
                score += 10+lastPins+pins;
                strike = false;
            }
        }
        if (isEndofFrame()) {
            if(pins+lastPins != 10){
                score += pins + lastPins ;
            }
            else{
                spare = true;
            }
        }
        else{
            if(pins==10){
                rollCount++;
                strike = true;
            }
            if(spare){
                score += 10+pins;
                spare = false;
            }
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
