package com.johannlo.ktbDevCamp.service;

import com.johannlo.ktbDevCamp.models.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMusicService {
    Music findMusicById(String id);

    List<Music> getAllMusic();

    void addMusic(Music music);

    void updateMusic(String id, Music music);

    void deleteMusicById(String id);
}
