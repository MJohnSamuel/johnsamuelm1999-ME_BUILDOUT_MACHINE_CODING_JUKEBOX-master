package com.example.demo.entities;

import java.util.List;

public class PlayList {
    private final Long playListId;
    private final String name;
    private List<Song> songs;


    public PlayList(Long playListId,PlayList entity) {
        this.playListId = playListId;
        this.name = entity.name;
        this.songs = entity.songs;
    }

    public Long getPlayListId() {
        return playListId;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + playListId + "]";
    }

    public PlayList(String name,List<Song> songs) {
        this.name = name;
        this.playListId = null;
        this.songs = songs;
    }

    
}

