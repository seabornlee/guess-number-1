package com.odde.guess.repo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
