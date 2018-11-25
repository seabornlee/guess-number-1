package com.odde.guess.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Data
@Entity
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private long id;

    private String secret;

    public Room(String secret) {
        this.secret = secret;
    }

    public String verify(String guess) {
        long countA = count(guess.length(), i -> equalDigital(guess, i));

        long countB = count(guess.length(), i -> containDigital(guess, i)) - countA;

        return String.format("%s %dA%dB", guess, countA, countB);
    }

    private boolean equalDigital(String guess, int i) {
        return guess.charAt(i) == secret.charAt(i);
    }

    private boolean containDigital(String guess, int i) {
        return secret.indexOf(guess.charAt(i)) >= 0;
    }

    private long count(int length, IntPredicate predicate) {
        return IntStream.range(0, length).filter(predicate).count();
    }

}
