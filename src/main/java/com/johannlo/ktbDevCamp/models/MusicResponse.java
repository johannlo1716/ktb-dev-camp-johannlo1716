package com.johannlo.ktbDevCamp.models;

public class MusicResponse {
    public Music music;
    public Lyric lyric;

    public  MusicResponse(Music music, Lyric lyric){
        this.music = music;
        this.lyric = lyric;
    }
}
