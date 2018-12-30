package com.odde.guess.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Data
@Entity
@NoArgsConstructor
public class Room {

    private static final String WIN_RESULT = "4A0B";
    @Id
    @GeneratedValue
    private long id;
    private String secret;
    @ElementCollection
    @CollectionTable(name = "GAME_LOGS", joinColumns = @JoinColumn(name = "ROOM_ID"))
    @Column(name = "LOG")
    private List<String> logs = new ArrayList<>();

    public Room(String secret) {
        this.secret = secret;
    }

    public GuessResult verify(String guess) {
        long countA = count(guess.length(), i -> equalDigital(guess, i));
        long countB = count(guess.length(), i -> containDigital(guess, i)) - countA;

        GuessResult result = new GuessResult(countA, countB);
        logs.add(String.format("%s %dA%dB", guess, result.getA(), result.getB()));
        return result;
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
