package com.example.demo.entities;

public class Node {
        public Song song;
        public Node next;
        public Node prev;
    
        public Node(Song song) {
            this.song = song;
        }
}
