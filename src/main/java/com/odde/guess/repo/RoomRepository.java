package com.odde.guess.repo;

import org.springframework.data.repository.Repository;

public interface RoomRepository extends Repository<Room, Long> {
    Room save(Room room);

    Room findById(long id);
}
