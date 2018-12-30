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

    @Test
    public void test_log() {
        Room room = new Room("1234");

        room.verify("5678");
        room.verify("1357");
        room.verify("1234");

        assertThat(room.getLogs()).containsExactly("5678 0A0B", "1357 1A1B", "1234 4A0B");
    }

    private void verifyGuess(String expectResult, String guess, String secret) {
        GuessResult result = new Room(secret).verify(guess);

        long a = Long.parseLong(expectResult.charAt(0) + "");
        long b = Long.parseLong(expectResult.charAt(2) + "");

        assertThat(result).isEqualTo(new GuessResult(a,b));
    }

}