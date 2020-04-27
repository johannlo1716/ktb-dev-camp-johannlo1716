package com.johannlo.ktb_dev_camp.controller;

import com.johannlo.ktb_dev_camp.model.Lyric;
import com.johannlo.ktb_dev_camp.model.Music;
import com.johannlo.ktb_dev_camp.repository.MusicRepository;
import com.johannlo.ktb_dev_camp.service.LyricService;
import com.johannlo.ktb_dev_camp.service.MusicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestApiControllerTest {

    @InjectMocks
    RestApiController restApiController;

    @Autowired
    private MusicRepository musicRepository = mock(MusicRepository.class);

    @Mock
    MusicService musicService = mock(MusicService.class);

    @Mock
    LyricService lyricService = mock(LyricService.class);

    private Music fakeMusic;

    @BeforeEach
    void setUp() {
    fakeMusic = new Music();
    fakeMusic.id = "test1";
    fakeMusic.genre = "testGenre";
    fakeMusic.name = "testMusic";
    fakeMusic.artist = "testArtist";
}

    @Test
    void defaultPage() {
        var music = restApiController.defaultPage();
        assert("Default Page".equals(music));

    }

    @Test
    void getMusic() {
        when(musicService.getAllMusic()).thenReturn(Arrays.asList(fakeMusic));
        when(lyricService.findLyrics(fakeMusic)).thenReturn(new Lyric("No lyrics found test"));
        var music = restApiController.getMusic();
        assertNotNull(music);
    }

    @Test
    void getMusicById() {
        when(musicService.findMusicById(fakeMusic.id)).thenReturn(fakeMusic);
        when(lyricService.findLyrics(fakeMusic)).thenReturn(new Lyric("No lyrics found test"));
        var music = restApiController.getMusicById("test1");
        assertNotNull(music);
    }

    @Test
    void addMusic() {
        restApiController.addMusic(fakeMusic);
    }
}