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

    public String verify(long id, String guess) {
        Room room = repo.findById(id);
        String result;
        if (room.getSecret().equals(guess)) {
            result = "4A0B";
        } else {
            result = "0A0B";
        }
        return result;
    }
}
