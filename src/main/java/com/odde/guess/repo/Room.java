package com.odde.guess.repo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;

    private final String secret;
}
