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
    private long a;
    private long b;

    public boolean isWin() {
        return getA() == 4;
    }
}
