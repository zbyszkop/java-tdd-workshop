package io.github.zbyszkop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void shouldCorrectlyScoreTwoFrames() {
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

    @Test
    public void shouldCorrectlyTallySpare(){
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(2);// 1st
        bowlingGame.roll(8);
        assertEquals(0, bowlingGame.getScore());
        bowlingGame.roll(4); //2nd
        assertEquals(14, bowlingGame.getScore());
        bowlingGame.roll(3);
        assertEquals(21, bowlingGame.getScore());
        bowlingGame.roll(5); //3rd
        assertEquals(21, bowlingGame.getScore());
    }

    @Test
    public void shouldCorrectlyTallyStrike(){
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(10);// 1st
        assertEquals(0, bowlingGame.getScore());
        bowlingGame.roll(2); //2nd
        assertEquals(0, bowlingGame.getScore());
        bowlingGame.roll(3);
        assertEquals(20, bowlingGame.getScore());
    }

    @Test
    public void shouldCorrectlyTallyTwoStrikes(){
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(10);// 1st
        assertEquals(0, bowlingGame.getScore());
        bowlingGame.roll(10); //2nd
        assertEquals(0, bowlingGame.getScore());
        bowlingGame.roll(2); //3rd
        assertEquals(22, bowlingGame.getScore());
        bowlingGame.roll(3);
        assertEquals(42, bowlingGame.getScore());
    }
}
