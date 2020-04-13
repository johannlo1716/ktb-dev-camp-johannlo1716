package com.johannlo.ktbDevCamp.repository;

import com.johannlo.ktbDevCamp.models.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, String>{

}
