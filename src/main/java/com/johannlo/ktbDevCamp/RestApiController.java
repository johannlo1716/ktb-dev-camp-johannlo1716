package com.johannlo.ktbDevCamp;

import com.google.gson.Gson;
import com.johannlo.ktbDevCamp.models.Music;
import com.johannlo.ktbDevCamp.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RestApiController {

    @Autowired
    private MusicService service;

    @RequestMapping("/")
    public String defaultPage() {
        return "Default Page";
    }

    @RequestMapping(value = "/music", method = RequestMethod.GET, produces = "application/json")
    public String getMusic() {
        return new Gson().toJson(service.getAllMusic());
    }

    @RequestMapping(value = "/music/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getMusicById(@PathVariable String id) {
        return new Gson().toJson(service.findMusicById(id));
    }

    @RequestMapping(value = "/music", method = RequestMethod.POST)
    public void addMusic(@RequestBody Music music) {
        service.addMusic(music);
    }

    @RequestMapping(value = "/music/{id}", method = RequestMethod.PUT)
    public void updateMusic(@PathVariable("id") String id, @RequestBody Music music) {
        service.updateMusic(id, music);
    }

    @RequestMapping(value = "/music/{id}", method = RequestMethod.DELETE)
    public void deleteMusic(@PathVariable("id") String id) {
        service.deleteMusicById(id);
    }
}