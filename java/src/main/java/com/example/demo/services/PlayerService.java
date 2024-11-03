package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.CircularDoubleLinkedList;
import com.example.demo.entities.Player;
import com.example.demo.entities.PlayerState;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlayListRepository;

public class PlayerService {
    private IPlayListRepository playListRepository;

    public PlayerService(IPlayListRepository playListRepository){
        this.playListRepository = playListRepository;
    }

    //LOAD_PLAYLIST PLAYLIST_1

    public String loadPlayList(List<String> tokens){
        CircularDoubleLinkedList queueList = new CircularDoubleLinkedList();
        List<Song> songs = playListRepository.findById(Long.valueOf(tokens.get(1).split("_")[1])).get().getSongs();
        for (Song song : songs) {
            queueList.append(song);
        }
        Player.player(PlayerState.IDLE, queueList, Long.valueOf(tokens.get(1).split("_")[1]));
       
        return "Playlist " + tokens.get(1) + " is loaded!";
    }


//    Song [id=2] is playing!

    public String playSong(List<String> tokens){
        Player player = Player.player();
       
        CircularDoubleLinkedList queueList =  player.getSongs();
        if(player.getPlayerState() == PlayerState.PLAYING){
            Player.player(PlayerState.PAUSED,queueList,player.getPlayerListId());
            return "Song [id="+ queueList.getHead().song.getSongId() +"] is paused!";
        }
        player = Player.player(PlayerState.PLAYING,queueList,player.getPlayerListId());

        return "Song [id="+ queueList.getHead().song.getSongId() +"] is playing!" ;
    }

    //PLAY_SONG

    public String nextSong(List<String> tokens){
        Player player = Player.player();
        CircularDoubleLinkedList queueList =  player.getSongs();

        if(player.getPlayerState() == PlayerState.IDLE || player.getPlayerState() == PlayerState.PAUSED 
           || player.getPlayerState() == PlayerState.STOPPED){
            queueList.moveNext();
            return "Please Play Song";
        }
        queueList.moveNext();
        return "Song [id="+ queueList.getHead().song.getSongId() +"] is playing!" ;
    }

    //PREVIOUS_SONG
    public String previousSong(List<String> tokens){
        Player player = Player.player();
        CircularDoubleLinkedList queueList =  player.getSongs();

        if(player.getPlayerState() == PlayerState.IDLE || player.getPlayerState() == PlayerState.PAUSED 
        || player.getPlayerState() == PlayerState.STOPPED){
         queueList.movePrevious();
         return "Please Play Song";
     }
        queueList.movePrevious();
        return "Song [id="+ queueList.getHead().song.getSongId() +"] is playing!" ;
    }

    public String stopSong(List<String> tokens){
        Player player = Player.player();
        CircularDoubleLinkedList queueList =  player.getSongs();
        Player.player(PlayerState.STOPPED, queueList, player.getPlayerListId());

        return "Song [id="+ queueList.getHead().song.getSongId() +"] is stopped!" ;
    }
}
