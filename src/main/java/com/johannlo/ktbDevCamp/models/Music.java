package com.johannlo.ktbDevCamp.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
@Table(name = "tbl_music")
public class Music implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String id;
    @Column(name = "name")
    public String name;
    @Column(name = "genre")
    public String genre;

    public Music() {
        this.id = java.util.UUID.randomUUID().toString();
    }
}
