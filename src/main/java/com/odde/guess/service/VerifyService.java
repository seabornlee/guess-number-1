package com.odde.guess.service;

import com.odde.guess.repo.Room;
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

    public String getResult(long id, String guess) {
        Room room = repo.findById(id);
        if (room.getSecret().equals(guess)) {
            return "You Win!";
        } else {
            return "0A0B";
        }
    }
}
