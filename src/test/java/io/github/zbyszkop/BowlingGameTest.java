package io.github.zbyszkop;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BowlingGameTest {
    @Test
    public void shouldScoreAsingleFrame() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(3);
        assertThat(bowlingGame.getScore()).isEqualTo(0);
        bowlingGame.roll(5);
        assertThat(bowlingGame.getScore()).isEqualTo(8);
    }

    @Test
    public void shouldScoreATwoFrames() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(3); // first roll a 1st frame
        assertThat(bowlingGame.getScore()).isEqualTo(0);
        bowlingGame.roll(5); // end of a 1st frame
        assertThat(bowlingGame.getScore()).isEqualTo(8);
        bowlingGame.roll(4); // first roll a 2nd frame
        assertThat(bowlingGame.getScore()).isEqualTo(8);
        bowlingGame.roll(2); // first roll a 2nd frame
        assertThat(bowlingGame.getScore()).isEqualTo(14);
    }
}
