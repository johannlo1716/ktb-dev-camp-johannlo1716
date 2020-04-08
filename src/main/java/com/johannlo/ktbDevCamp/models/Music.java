package com.johannlo.ktbDevCamp.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity
@ToString
public class Music {
    public UUID id;
    public String name;
    public String genre;


    Music() {
        this.id = java.util.UUID.randomUUID();
    }
}
