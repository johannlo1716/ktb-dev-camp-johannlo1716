package com.johannlo.ktbDevCamp.service;

import com.johannlo.ktbDevCamp.models.Lyric;
import com.johannlo.ktbDevCamp.models.Music;
import org.springframework.http.ResponseEntity;
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
            ResponseEntity<Lyric> response = restTemplate.getForEntity(url, Lyric.class);
            lyric = response.getBody();
        } catch (RestClientResponseException exception) {
            lyric = new Lyric("No lyrics found.");
        }

        return lyric;
    }
}
