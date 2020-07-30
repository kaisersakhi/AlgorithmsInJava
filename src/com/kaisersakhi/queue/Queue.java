package com.kaisersakhi.queue;
//owner : kaiser sakhi
import com.kaisersakhi.Node;
public class Queue<Type> {
    Node<Type> front;
    Node<Type> rear;
    Type data;
    int size;
    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    public boolean enqueue(Type data){
        Node<Type> node = new Node<>(data);
        if (front == null){
            front = rear = node;
            size++;
            return true;
        }else if (size > 0){
            rear.next = node;
            rear = node;
            size++;
            return true;
        }
        return false;
    }

    public Type dequeue(){
        Type data = null;
        if (size > 0){
            data = front.data;
            front = front.next;
            --size;
        }
        return data;
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
