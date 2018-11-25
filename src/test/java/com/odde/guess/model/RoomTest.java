package com.odde.guess.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoomTest {
    @Test
    public void guess_win() {
        verifyGuess("4A0B", "1234", "1234");
    }

    @Test
    public void guess_wrong() {
        verifyGuess("0A0B", "5678", "1234");
    }

    @Test
    public void _1A0B() {
        verifyGuess("1A0B", "1678", "1234");
        verifyGuess("1A0B", "5278", "1234");
        verifyGuess("1A0B", "5638", "1234");
        verifyGuess("1A0B", "5674", "1234");
    }

    @Test
    public void _2A0B() {
        verifyGuess("2A0B", "1278", "1234");
    }

    @Test
    public void _0A1B() {
        verifyGuess("0A1B", "5178", "1234");
    }

    @Test
    public void _0A2B() {
        verifyGuess("0A2B", "2178", "1234");
    }

    private void verifyGuess(String expectResult, String guess, String secret) {
        String result = new Room(secret).verify(guess);
        assertThat(result).isEqualTo(guess + " " + expectResult);
    }

}