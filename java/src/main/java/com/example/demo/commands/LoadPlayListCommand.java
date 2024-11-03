package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayerService;

public class LoadPlayListCommand implements ICommand{
    private final PlayerService playerService;

    public LoadPlayListCommand(PlayerService playerService){
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        System.out.println(playerService.loadPlayList(tokens));
    }
    
}
