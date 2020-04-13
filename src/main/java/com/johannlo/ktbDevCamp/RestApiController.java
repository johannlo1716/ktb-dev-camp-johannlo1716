package com.johannlo.ktbDevCamp;

import com.google.gson.Gson;
import com.johannlo.ktbDevCamp.models.Music;
import com.johannlo.ktbDevCamp.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class RestApiController {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Module.xml");
    IMusicService service = (IMusicService) ctx.getBean("musicdao");

    @RequestMapping("/")
    public String defaultPage() {
        return "Default Page";
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.GET, produces = "application/json")
    public String getMusic() {
        return new Gson().toJson(service.getAllMusic());
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getMusicById(@PathVariable String id) {
        return new Gson().toJson(service.findMusicById(id));
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.POST)
    public void addMusic(@RequestBody Music music) {
        service.addMusic(music);
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.PUT)
    public void updateMusic(@PathVariable("id") String id, @RequestBody Music music) {
        service.updateMusic(id, music);
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.DELETE)
    public void deleteMusic(@PathVariable("id") String id) {
        service.deleteMusicById(id);
    }
}