package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayListService;

public class AddSongToPlayListComnnad implements ICommand {

    private PlayListService playListService;

    public AddSongToPlayListComnnad(PlayListService playListService){
        this.playListService = playListService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(playListService.addSong2PlayList(tokens));
    }
}
