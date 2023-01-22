package com.kaisersakhi.linkedlist;

public class DoublyLinkedList <T>{
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.head = this.tail = null;
        this.size = 0;
    }
    public void append(T data){
        if (head == null){
            head = new ListNode<>(data);
            tail = head;
            ++size;
            return;
        }
        ListNode<T> newNode = new ListNode<>(data);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        ++size;
    }

    public void prepend(T data){
        if (head == null){
            head = tail = new ListNode<>(data);
            ++size;
            return;
        }
        ListNode<T> node = new ListNode<>(data);
        node.next = head;
        head.previous = node;
        head = node;
        ++size;
    }

    public T pop(){
        if (size < 1) return null;
        T data = tail.data;
        tail = tail.previous;
        if (tail != null){
            tail.next = null;
        }
        --size;
        if (size == 0) tail = head = null;
        return data;
    }

    public T popHead(){
        if (size < 1) return null;
        T data = head.data;
        head = head.next;
        if (head != null){
            head.previous = null;
        }
        --size;
        if (size == 0) tail = head = null;
        return data;
    }


    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        ListNode<T> current = head;
        while (current != null) {
            stringBuilder.append(current.data.toString());
            if (current.next == null){
                break;
            }
            current = current.next;
            stringBuilder.append(", ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }


    public int size(){return this.size;}
    public boolean isNotEmpty(){return size > 0;}
}
