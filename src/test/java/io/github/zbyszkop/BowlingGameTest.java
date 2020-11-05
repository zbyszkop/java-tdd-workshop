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

    @Test
    public void shouldCorrectlyScoreASpare() {
        BowlingGame game = new BowlingGame();

        game.roll(2);
        game.roll(8);
        assertThat(game.getScore()).isEqualTo(0);

        game.roll(4);
        assertThat(game.getScore()).isEqualTo(10+4);
        game.roll(3);
        assertThat(game.getScore()).isEqualTo(10+4+7);
    }

    @Test
    public void shouldCorrectlyScoreTwoConsecutiveSpares() {
        BowlingGame game = new BowlingGame();


        game.roll(2);
        game.roll(8);
        assertThat(game.getScore()).isEqualTo(0);

        game.roll(3);
        assertThat(game.getScore()).isEqualTo(13);
        game.roll(7);
        assertThat(game.getScore()).isEqualTo(13);

        game.roll(5);
        assertThat(game.getScore()).isEqualTo(13+15);
        game.roll(4);
        assertThat(game.getScore()).isEqualTo(13+15+9);
    }

    @Test
    public void shouldCorrectlyScoreFullSpareGame() {
        BowlingGame game = new BowlingGame();

        for (int i = 0; i < 21; i++) {
            game.roll(5);
        }
        assertThat(game.getScore()).isEqualTo(150);
    }

    @Test
    public void shouldCorrectlyScoreSingleStrike() {
        BowlingGame game = new BowlingGame();

        game.roll(10);
        assertThat(game.getScore()).isEqualTo(0);

        game.roll(2);
        game.roll(5);
        assertThat(game.getScore()).isEqualTo(10+7+7);
    }

    @Test
    public void shouldCorrectlyScoreSingleStrikeFollowedByTwoNonStrikes() {
        BowlingGame game = new BowlingGame();

        game.roll(10);
        assertThat(game.getScore()).isEqualTo(0);

        game.roll(2);
        game.roll(5);
        assertThat(game.getScore()).isEqualTo(10+7+7);

        game.roll(1);
        game.roll(2);
        assertThat(game.getScore()).isEqualTo(10+7+7+3);
    }

    public void shouldCorrectlyScoreThreeConsecutiveStrikesFollowedByNonStrike() {
        BowlingGame game = new BowlingGame();

        game.roll(10);
        assertThat(game.getScore()).isEqualTo(0);

        game.roll(10);
        assertThat(game.getScore()).isEqualTo(0);

        game.roll(10);
        assertThat(game.getScore()).isEqualTo(30);

        game.roll(1);
        assertThat(game.getScore()).isEqualTo(30+21);
        game.roll(4);
        assertThat(game.getScore()).isEqualTo(30+21+15);
    }
}

