package com.johannlo.ktb_dev_camp.controller;

import com.johannlo.ktb_dev_camp.model.Music;
import com.johannlo.ktb_dev_camp.model.MusicResponse;
import com.johannlo.ktb_dev_camp.service.LyricService;
import com.johannlo.ktb_dev_camp.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class RestApiController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private LyricService lyricService;


    @RequestMapping("/")
    public String defaultPage() {
        return "Default Page";
    }

    @RequestMapping(value = "/music", method = RequestMethod.GET, produces = "application/json")
    public List<MusicResponse> getMusic() {
        List<MusicResponse> response = new ArrayList<>();
        var listOfMusic = musicService.getAllMusic();
        for (var music: listOfMusic){
            var lyrics = lyricService.findLyrics(music);
            response.add(new MusicResponse(music, lyrics));
        }
        return response;
    }
    @RequestMapping(value = "/music/{id}", method = RequestMethod.GET, produces = "application/json")
    public MusicResponse getMusicById(@PathVariable String id) {
        var music = musicService.findMusicById(id);
        return new MusicResponse(music, lyricService.findLyrics(music));
    }

    @RequestMapping(value = "/music", method = RequestMethod.POST)
    public void addMusic(@RequestBody Music music) {
        musicService.addMusic(music);
    }

    @RequestMapping(value = "/music/{id}", method = RequestMethod.PUT)
    public void updateMusic(@PathVariable("id") String id, @RequestBody Music music) {
        musicService.updateMusic(id, music);
    }

    @RequestMapping(value = "/music/{id}", method = RequestMethod.DELETE)
    public void deleteMusic(@PathVariable("id") String id) {
        musicService.deleteMusicById(id);
    }
}