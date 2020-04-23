package com.johannlo.ktb_dev_camp.repository;

import com.johannlo.ktb_dev_camp.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, String>{

}
