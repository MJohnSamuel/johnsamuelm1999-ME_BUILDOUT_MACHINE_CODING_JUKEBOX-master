package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayerService;

public class PreviousSongCommand implements ICommand {

    private PlayerService playerService;

    public PreviousSongCommand(PlayerService playerService){
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(playerService.previousSong(tokens));
    }
    
}
