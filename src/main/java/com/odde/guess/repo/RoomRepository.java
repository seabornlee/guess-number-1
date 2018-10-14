package com.odde.guess.repo;

import com.odde.guess.model.Room;
import org.springframework.data.repository.Repository;

public interface RoomRepository extends Repository<Room, Long> {
    Room save(Room room);

    Room findById(long id);
}
