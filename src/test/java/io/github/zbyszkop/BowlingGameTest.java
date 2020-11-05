package io.github.zbyszkop;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void shouldTallyTScoreOnlyAfterTheFrame() {
        BowlingGame game = new BowlingGame();
        game.roll(3);
        assertThat(game.getScore()).isEqualTo(0);
        game.roll(5);
        assertThat(game.getScore()).isEqualTo(8);
    }

    @Test
    public void shouldCountTheWholeGame() {
        BowlingGame game = new BowlingGame();

        for (int i =0; i < 10; i++) {
            game.roll(3);
            game.roll(5);
        }
        assertThat(game.getScore()).isEqualTo(80);
    }
}
