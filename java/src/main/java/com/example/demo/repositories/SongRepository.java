package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository{

    private final Map<Long,Song> storage = new HashMap<>();
    private AtomicLong id = new AtomicLong(0);

    @Override
    public Song getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Song save(Song entity) {
        // TODO Auto-generated method stub
        
        Song song = new Song(id.incrementAndGet(), entity);
        storage.putIfAbsent(song.getSongId(), song);
        return song;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return storage.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Song> findAll() {
        // TODO Auto-generated method stub
        List<Song> songs = new ArrayList<>();
        for (Map.Entry<Long,Song> entry : storage.entrySet()){
            songs.add(entry.getValue());
        } 
        return songs;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
