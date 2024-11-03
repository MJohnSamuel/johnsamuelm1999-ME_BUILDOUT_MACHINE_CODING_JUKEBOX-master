package com.example.demo.entities;

public class CircularDoubleLinkedList {
    private Node head = null;

    public void append(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public Node getHead() {
        return head;
    }

    public void moveNext(){
        head = head.next;
    }

    public void movePrevious(){
        head = head.prev;
    }

}
