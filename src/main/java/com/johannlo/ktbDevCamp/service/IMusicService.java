package com.johannlo.ktbDevCamp.service;

import com.johannlo.ktbDevCamp.models.Music;

import java.util.List;

public interface IMusicService {
    Music findMusicById(String id);

    List<Music> getAllMusic();

    void addMusic(Music music);

    void updateMusic(String id, Music music);

    void deleteMusicById(String id);
}
