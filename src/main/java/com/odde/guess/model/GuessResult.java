package com.odde.guess.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@NoArgsConstructor
public class GuessResult {
    @Id
    @GeneratedValue
    private long id;
    private String guess;
    private long a;
    private long b;

    public GuessResult(String guess, long a, long b) {
        this.guess = guess;
        this.a = a;
        this.b = b;
    }

    public boolean isWin() {
        return a == 4;
    }

    public String getMessage() {
        return String.format("%s %dA%dB", guess, a, b);
    }
}

