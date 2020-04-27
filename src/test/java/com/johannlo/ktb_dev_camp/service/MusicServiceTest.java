package com.johannlo.ktb_dev_camp.service;

import com.johannlo.ktb_dev_camp.model.Music;
import com.johannlo.ktb_dev_camp.repository.MusicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MusicServiceTest {
    @InjectMocks
    MusicService musicService;

    @Autowired
    MusicRepository musicRepository = mock(MusicRepository.class);

    private Music fakeMusic;

    @BeforeEach
    public void setUp() {
        fakeMusic = new Music();
        fakeMusic.id = "test1";
        fakeMusic.genre = "testGenre";
        fakeMusic.name = "testMusic";
        fakeMusic.artist = "testArtist";
    }

    @Test
    void addMusic() {
        musicService = mock(MusicService.class);
        musicService.addMusic(fakeMusic);
        musicService.addMusic(fakeMusic);
        verify(musicService, times(2)).addMusic(fakeMusic);
    }

    @Test
    void findMusicById() {
        when(musicRepository.findById(fakeMusic.id)).thenReturn(Optional.of(fakeMusic));
        var test = musicService.findMusicById(fakeMusic.id);
        assert (test.equals(fakeMusic));
}

    @Test
    void getAllMusic() {
        when(musicRepository.findAll()).thenReturn(asList(fakeMusic));
        var test = musicService.getAllMusic();
        var test2 = musicRepository.findAll();
        assertNotNull(test);
        assert (test.equals(test2));
    }
}