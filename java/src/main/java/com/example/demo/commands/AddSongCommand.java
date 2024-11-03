package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.SongService;

public class AddSongCommand implements ICommand {

    private SongService songService;

    public AddSongCommand(SongService songService){
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(songService.addSong(tokens));
    }
    
}
