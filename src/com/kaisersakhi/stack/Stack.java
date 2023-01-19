package com.kaisersakhi.stack;


import com.kaisersakhi.linkedlist.SinglyLinkedList;


public class Stack<T> {
    private final SinglyLinkedList<T> list;
    Stack(){
        this.list = new SinglyLinkedList<T>();
    }

    public void push(T dataItem){ //takes O(1)
        list.prepend(dataItem);
    }
    public T pop(){ //takes O(1)
        return list.popHead();
    }
    public boolean isNotEmpty(){ //takes O(1)
        return list.size() > 0;
    }
    public T peek(){ //takes O(1)
        return list.getHead();
    }
}
