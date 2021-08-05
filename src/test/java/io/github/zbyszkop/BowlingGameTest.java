package io.github.zbyszkop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void shouldAllowRollingAndGettingScore() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(4);  //first frame
        assertEquals(0, bowlingGame.getScore());
        bowlingGame.roll(5);
        assertEquals(9, bowlingGame.getScore());
        bowlingGame.roll(3);  //second frame
        assertEquals(9, bowlingGame.getScore());
        bowlingGame.roll(2);
        assertEquals(14, bowlingGame.getScore());
    }
}
