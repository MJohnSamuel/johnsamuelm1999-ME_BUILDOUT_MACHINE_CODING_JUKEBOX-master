package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlayListRepository;
import com.example.demo.repositories.ISongRepository;

public class PlayListService {

    private ISongRepository songRepository;
    private IPlayListRepository playListRepository;


    public PlayListService(ISongRepository songRepository,IPlayListRepository playListRepository){
        this.songRepository = songRepository;
        this.playListRepository = playListRepository;
    }


    private String listOfSongsInPlayList(PlayList playList){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean x = true;
        for (Song song : playList.getSongs()) {
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

    private boolean isSongPresentInPlayList(PlayList playList,Long songId){
        for(Song song : playList.getSongs()) {
            if(song.getSongId() == songId){
                return true;
            }
        }
            return false;
}


    public String createPlayList(List<String> tokens){
        String name = tokens.get(1);
        List<Song> songs = new ArrayList<>();
        for (int i=2; i<tokens.size();i++) {
            if(songRepository.existsById(Long.valueOf(tokens.get(i)))){
                songs.add(songRepository.findById(Long.valueOf(tokens.get(i))).get());
            }
        }
        PlayList playList =  playListRepository.save(new PlayList(name, songs));
        return playList.toString();
    }

   
    /*
    DELETE_PLAYLIST PLAYLIST_1
    ADD_SONG_TO_PLAYLIST PLAYLIST_2 8
    DELETE_SONG_FROM_PLAYLIST PLAYLIST_2 9 
    */

    public String deletePlayList(List<String> tokens){
        if(playListRepository.existsById(Long.valueOf(tokens.get(1).split("_")[1]))){
            playListRepository.deleteById(Long.valueOf(tokens.get(1).split("_")[1]));
            return "Playlist "+ tokens.get(1) + " is deleted!" ;
        }
        else{
            return "Error in the playListId" ;
        }
    }

    public String addSong2PlayList(List<String> tokens){
        if(songRepository.existsById(Long.valueOf(tokens.get(2))) 
            && playListRepository.existsById(Long.valueOf(tokens.get(1).split("_")[1]))){
                PlayList playList = playListRepository.findById(Long.valueOf(tokens.get(1).split("_")[1])).get();
                playList.getSongs().add(songRepository.findById(Long.valueOf(tokens.get(2))).get());
                return "Playlist "+ tokens.get(1) + " is revised with " + listOfSongsInPlayList(playList);
            }
        else{
            return "Error with either Playlist or Song Id";
        }
    }

  

    public String deleteSongFromPlayList(List<String> tokens){
        if(songRepository.existsById(Long.valueOf(tokens.get(2))) 
            && playListRepository.existsById(Long.valueOf(tokens.get(1).split("_")[1]))){
                PlayList playList = playListRepository.findById(Long.valueOf(tokens.get(1).split("_")[1])).get();
                if(isSongPresentInPlayList(playList,Long.valueOf(tokens.get(2)))){
                    playList.getSongs().remove(songRepository.findById(Long.valueOf(tokens.get(2))).get());
                   }

                   return "Playlist "+ tokens.get(1) + " is revised with " + listOfSongsInPlayList(playList);
                }
        else{
            return "Error with either Playlist or Song Id";
        }
    }

}