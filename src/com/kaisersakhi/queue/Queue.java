package com.kaisersakhi.queue;

import com.kaisersakhi.linkedlist.DoublyLinkedList;

public class Queue <T>{
    private final DoublyLinkedList<T> list;

    public Queue(){
        list = new DoublyLinkedList<T>();
    }

    public  void enqueue(T data){
        list.append(data);
    }

    public T dequeue(){
        return list.popHead();
    }

    public boolean isNotEmpty(){return list.isNotEmpty();}
    public boolean isEmpty(){return !list.isNotEmpty();}
    public int size(){return list.size();}

    public T peekFront(){
        return list.peekFront();
    }
}
