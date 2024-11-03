package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.example.demo.entities.PlayList;

public class PlayListRepository implements IPlayListRepository{

    private final Map<Long,PlayList> storage = new HashMap<>();
    private AtomicLong id = new AtomicLong(0);

    @Override
    public PlayList save(PlayList entity) {
        // TODO Auto-generated method stub
        PlayList playList = new PlayList(id.incrementAndGet(),entity);
        storage.putIfAbsent(playList.getPlayListId(), playList);
        return playList;
    }

    @Override
    public PlayList getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return storage.containsKey(id);
    }

    @Override
    public Optional<PlayList> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<PlayList> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        storage.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
