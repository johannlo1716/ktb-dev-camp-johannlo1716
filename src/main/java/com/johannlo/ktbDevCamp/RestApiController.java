package com.johannlo.ktbDevCamp;

import com.google.gson.Gson;
import com.johannlo.ktbDevCamp.models.Music;
import com.johannlo.ktbDevCamp.service.MusicService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class RestApiController {
    List<Music> musicList = new ArrayList<Music>();

    ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    MusicService service = (MusicService) ctx.getBean("musicdao");

    @RequestMapping("/")
    @ResponseBody

    public String defaultPage() {
        return "Default Page";
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getMusic() {
        return new Gson().toJson(service.getAllMusic());
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getMusicById(@PathVariable String id) {
        return new Gson().toJson(service.findMusicById(id));
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.POST)
    @ResponseBody
    public void addMusic(@RequestBody Music music) {
        service.addMusic(music);
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateMusic(@PathVariable("id") String id, @RequestBody Music music) {
        service.updateMusic(id, music);
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMusic(@PathVariable("id") String id) {
        service.deleteMusicById(id);
    }
}