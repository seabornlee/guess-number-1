package com.odde.guess.service;

import com.odde.guess.repo.Room;
import com.odde.guess.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@Service
public class VerifyService {
    RoomRepository repo;

    @Autowired
    public VerifyService(RoomRepository repo) {
        this.repo = repo;
    }

    public String verify(long id, String guess) {
        Room room = repo.findById(id);

        long countA = count(guess.length(), i -> equalDigital(room.getSecret(), guess, i));

        long countB = count(guess.length(), i -> containDigital(room.getSecret(), guess, i)) - countA;


        return String.format("%dA%dB", countA, countB);
    }

    private long count(int length, IntPredicate predicate) {
        return IntStream.range(0, length).filter(predicate).count();
    }

    private boolean containDigital(String secret, String guess, int i) {
        return secret.indexOf(guess.charAt(i)) >= 0;
    }

    private boolean equalDigital(String secret, String guess, int i) {
        return guess.charAt(i) == secret.charAt(i);
    }
}
