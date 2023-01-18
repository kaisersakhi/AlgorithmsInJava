package com.kaisersakhi.linkedlist;

import java.util.List;

public class ListNode<T> {
    T data = null;
    ListNode<T> previous;
    ListNode<T> next;

    ListNode(){
        this.data = null;
    }

    ListNode(T data){
        this.data = data;
    }
}
