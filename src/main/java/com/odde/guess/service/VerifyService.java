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

        long countA = count(guess.length(), i -> room.equalDigital(guess, i));

        long countB = count(guess.length(), i -> room.containDigital(guess, i)) - countA;


        return String.format("%dA%dB", countA, countB);
    }

    private long count(int length, IntPredicate predicate) {
        return IntStream.range(0, length).filter(predicate).count();
    }

}
