package com.example.demo.entities;

public enum PlayerState {
    IDLE("IDLE"),
    PAUSED("PAUSED"),
    PLAYING("PLAYING"),
    STOPPED("STOPPED");


    private final String state;

    private PlayerState(String state){
        this.state = state;
    }

    public String getState() {
        return state;
     } 
}
