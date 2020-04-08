package com.johannlo.ktbDevCamp;

import com.google.gson.Gson;
import com.johannlo.ktbDevCamp.models.Music;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class HelloWorldController {
    List<Music> musicList = new ArrayList<Music>();
    private static final String version = "/v1";
    private static final String getUrl = version + "/music";

    @RequestMapping("/")
    @ResponseBody
    public String defaultPage() {
        return "Default Page";
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getMusic() {
        return new Gson().toJson(musicList);
    }

    @RequestMapping(value = "/v1/music", method = RequestMethod.POST)
    @ResponseBody
    public void setMusic(@RequestBody Music music) {
        musicList.add(music);
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateMusic(@PathVariable("id") String id, @RequestBody Music music) {
        if (!musicList.isEmpty() || musicList != null) {
            for (Music item : musicList) {
                if (item.id.toString().equals(id)) {
                    item.name = music.name;
                    item.genre = music.genre;
                    break;
                }
            }
        }
    }

    @RequestMapping(value = "/v1/music/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteMusic(@PathVariable("id") String id) {

        if (!musicList.isEmpty() || musicList != null) {
            /*
            Iterator<Music> obj = musicList.iterator();
            while(obj.hasNext()){
                Music music = obj.next();
                if(music.id.toString().equals(id)){
                    obj.remove();
                }
            }
            */
            for (var obj : musicList) {
                if (obj.id.toString().equals(id)) {
                    musicList.remove(obj);
                }
            }
        }
    }
}