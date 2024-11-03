package com.example.demo.entities;


public class Player {
    private static Player player_instance = null;
    private PlayerState playerState;
    private CircularDoubleLinkedList songs;
    private Long playerListId;

    
    
    public PlayerState getPlayerState() {
        return playerState;
    }

    public static Player player()
    {
        // To ensure only one instance is created
        return player_instance;
    }

    public static Player player(PlayerState playerState, CircularDoubleLinkedList songs, Long playerListId)
    {
        // To ensure only one instance is created
        if (player_instance == null) {
            player_instance = new Player(playerState,songs,playerListId);
        }else{
            player_instance.playerListId = playerListId;
            player_instance.playerState = playerState;
            player_instance.songs = songs;
        }
        return player_instance;
    }
    private Player(PlayerState playerState, CircularDoubleLinkedList songs, Long playerListId) {
        this.playerState = playerState;
        this.songs = songs;
        this.playerListId = playerListId;
    }
    public CircularDoubleLinkedList getSongs() {
        return songs;
    }
    public Long getPlayerListId() {
        return playerListId;
    }

}
