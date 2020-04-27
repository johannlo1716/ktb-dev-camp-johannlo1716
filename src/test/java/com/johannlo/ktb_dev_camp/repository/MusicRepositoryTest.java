package com.johannlo.ktb_dev_camp.repository;

import com.johannlo.ktb_dev_camp.model.Music;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Optional;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class MusicRepositoryTest {
    @InjectMocks
    private MusicRepository musicRepository = mock(MusicRepository.class);

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
    void save() {
        musicRepository.save(fakeMusic);
        verify(musicRepository, times(1)).save(fakeMusic);
    }

    @Test
    void findMusicById() {
        when(musicRepository.findById("test1")).thenReturn(Optional.of(fakeMusic));
        var test = musicRepository.findById(fakeMusic.id);
        assert(fakeMusic.equals(test.get()));
    }

    @Test
    void getAllMusic() {
        when(musicRepository.findAll()).thenReturn(asList(fakeMusic));
        assert (musicRepository.findAll().equals(asList(fakeMusic)));
    }
}