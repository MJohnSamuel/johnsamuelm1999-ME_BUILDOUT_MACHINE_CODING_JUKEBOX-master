package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PlayList;

public interface IPlayListRepository {
    public PlayList save(PlayList playlist);
    public PlayList getById(Long id);
    boolean existsById(Long id);
    Optional<PlayList> findById(Long id);
    List<PlayList> findAll();
    void deleteById(Long id);
    long count();
}
