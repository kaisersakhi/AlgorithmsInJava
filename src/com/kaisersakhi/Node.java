package com.kaisersakhi;
//owner : kaiser sakhi
public class Node<T> {
    public Node<T> pre;
    public T data;
    public Node<T> next;

    public Node(T data){
        this.data = data;
        this.pre = null;
        this.next = null;
    }

}
