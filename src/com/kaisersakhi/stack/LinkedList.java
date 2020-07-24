package com.kaisersakhi.stack;
import com.kaisersakhi.stack.Node;

public class LinkedList<Type>{
    Node<Type> head;
    int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(Type data){
        Node<Type> node = new Node<Type>(data);
        if (this.head == null){
            this.head = node;
            this.size++;
        }else{
            Node<Type> current = this.head;
            while (current.next!= null){
                current = current.next;
            }
            current.next = node;
            this.size++;
        }
    }

    public  void display(){
        if (this.size > 0){
            Node<Type> current = this.head;
            while (current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}
