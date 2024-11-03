package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayerService;

public class PlaySongCommand implements ICommand {

    private PlayerService playerService;

    public PlaySongCommand(PlayerService playerService){
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(playerService.playSong(tokens));
    }
    
}
