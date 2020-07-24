package com.kaisersakhi.stack;

public class Node<T> {
    protected Node<T> pre;
    protected T data;
    protected Node<T> next;

    Node(T data){
        this.data = data;
        this.pre = null;
        this.next = null;
    }

}
