package com.johannlo.ktbDevCamp.service;

import com.johannlo.ktbDevCamp.models.Music;
import com.johannlo.ktbDevCamp.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private MusicRepository repository;

    @Override
    @Transactional
    public Music findMusicById(String id) {
        /*String sql = "select * from tbl_music where id = '" + id + "'";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Music.class));*/

        var temp = repository.findById(id);
        var temp2 = temp.get();
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Music> getAllMusic() {
        /*String sql = "select * from tbl_music";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Music.class));*/
        return (List<Music>) repository.findAll();
    }

    @Override
    public void addMusic(Music music) {

        String sql = "insert into tbl_music (id, name, genre) VALUES (?, ?, ?)";
        Object[] params = new Object[]{music.id.toString(), music.name, music.genre};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void updateMusic(String id, Music music) {
        Music musicInDb = findMusicById(id);
        if (music.name != null && !music.name.isEmpty())
            musicInDb.name = music.name;

        if (music.genre != null && !music.genre.isEmpty())
            musicInDb.genre = music.genre;

        String sql = "UPDATE tbl_music SET name = ?, genre = ? where id = '" + id + "'";
        Object[] params = new Object[]{musicInDb.name, musicInDb.genre};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteMusicById(String id) {
        String sql = "DELETE FROM tbl_music where id = '" + id + "'";
        jdbcTemplate.update(sql);
    }
}
