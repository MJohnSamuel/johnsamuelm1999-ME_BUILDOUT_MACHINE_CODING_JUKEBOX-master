package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Song;

public interface ISongRepository {
    public Song getById(Long id);
    Song save(Song song);
    boolean existsById(Long id);
    Optional<Song> findById(Long id);
    List<Song> findAll();
    void deleteById(Long id);
    long count();
}
