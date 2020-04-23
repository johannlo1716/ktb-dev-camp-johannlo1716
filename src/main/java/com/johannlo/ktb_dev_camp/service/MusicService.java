package com.johannlo.ktb_dev_camp.service;

import com.johannlo.ktb_dev_camp.model.Music;
import com.johannlo.ktb_dev_camp.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository repository;

    public Music findMusicById(String id) {
        return repository.findById(id).get();
    }

    public List<Music> getAllMusic() {
        return (List<Music>) repository.findAll();
    }

    public void addMusic(Music music) {
        repository.save(music);
    }

    public void updateMusic(String id, Music music) {
        Music musicInDb = findMusicById(id);
        if (music.name != null && !music.name.isEmpty())
            musicInDb.name = music.name;

        if (music.genre != null && !music.genre.isEmpty())
            musicInDb.genre = music.genre;
        repository.save(musicInDb);
    }


    public void deleteMusicById(String id) {
        repository.deleteById(id);
    }
}
