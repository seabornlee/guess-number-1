package com.odde.guess.service;

import com.odde.guess.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyService {
    RoomRepository repo;

    @Autowired
    public VerifyService(RoomRepository repo) {
        this.repo = repo;
    }

    public String verify(long id, String guess) {
        return repo.findById(id).verify(guess);
    }

}
