package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {
    private ISongRepository songRepository;

    public SongService(ISongRepository songRepository){
        this.songRepository = songRepository;
    }

    /*
    ADD_SONG Song_1 Artist_1 Album_1 Genre_1
    ADD_SONG Song_2 Artist_2 Album_2 Genre_2
     * 
    */
    public String addSong(List<String> tokens){
        String songName = tokens.get(1);
        String artistName = tokens.get(2);
        String albumName = tokens.get(3);
        String genreName = tokens.get(4);

        Song song =  songRepository.save(new Song(songName, genreName, albumName, artistName));

        return song.toString();
    }

    public String listSong(List<String> tokens){
        List<Song> songs = songRepository.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean x = true;
        for (Song song : songs) {
            if(x){
                sb.append(song.toString());
                x=false;
            }
            else{
                sb.append(", ").append(song.toString());
            }
           
        }
        sb.append("]");
        return sb.toString();
    }

}
