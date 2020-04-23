package com.johannlo.ktb_dev_camp.service;

import com.johannlo.ktb_dev_camp.model.Lyric;
import com.johannlo.ktb_dev_camp.model.Music;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class LyricService {
    public Lyric findLyrics(Music music) {
        RestTemplate restTemplate = new RestTemplate();
        var lyric = new Lyric("");
        String url = "https://api.lyrics.ovh/v1/" + music.artist + "/" + music.name;

        try {
            lyric = restTemplate.getForEntity(url, Lyric.class).getBody();
        } catch (RestClientResponseException exception) {
            lyric = new Lyric("No lyrics found.");
        }

        return lyric;
    }
}
