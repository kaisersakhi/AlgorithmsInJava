package com.kaisersakhi.queue;
//owner : kaiser sakhi
import com.kaisersakhi.Node;
public class Queue<Type> {
    Node<Type> front;
    Node<Type> rear;
    private Type data;
    private int size;
    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    public void enqueue(Type data){
        Node<Type> node = new Node<>(data);
        if (front == null){
            front = rear = node;
            size++;
        }else if (size > 0){
            rear.next = node;
            rear = node;
            size++;
        }
    }

    public Type dequeue(){
        Type data = null;
        if (size > 0){
            data = front.data;
            front = front.next;
            --this.size;
        }
        return data;
    }
    //return the object of type Type at the front of the queue
    public Type getFrontData(){
        //if size is greater then 0 then return the data
        if (size > 0)
            return front.data;
        //else return null
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //ausuming im working with integers
    public void display(){
        if (size > 0){
            Node<Type> current = this.front;
            while (current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}
