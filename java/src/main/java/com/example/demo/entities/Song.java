package com.example.demo.entities;

public class Song {
    private Long songId;
    private String name;
    private String genre;
    private String album;
    private String artist;

    
    public Song(String name, String genre, String album, String artist) {
        this.songId = null;
        this.name = name;
        this.genre = genre;
        this.album = album;
        this.artist = artist;
    }

    public Song(Long songId , Song entity){
        this.songId = songId;
        this.name = entity.name;
        this.genre = entity.genre;
        this.album = entity.album;
        this.artist = entity.artist;
    }

    public Long getSongId() {
        return songId;
    }
    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public String getAlbum() {
        return album;
    }
    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Song [id=" + this.songId + "]";
    }


}
