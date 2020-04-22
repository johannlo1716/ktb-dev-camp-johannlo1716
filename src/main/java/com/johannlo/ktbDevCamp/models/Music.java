package com.johannlo.ktbDevCamp.models;

import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;


@Entity
@ToString
@Table(name = "tbl_music")
public class Music {
    @Id
    @Column(name = "id")
    public String id;
    @Column(name = "name")
    public String name;
    @Column(name = "genre")
    public String genre;
    @Column(name = "artist")
    public String artist;

    public Music(){
        this.id = UUID.randomUUID().toString();
    }

}
