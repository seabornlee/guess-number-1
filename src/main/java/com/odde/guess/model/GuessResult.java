package com.odde.guess.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class GuessResult {
    private String guess;
    private long a;
    private long b;

    public boolean isWin() {
        return a == 4;
    }

    String getMessage() {
        return String.format("%s %dA%dB", guess, a, b);
    }
}
