package com.kaisersakhi;
import com.kaisersakhi.linkedlist.LinkedList;
import com.kaisersakhi.queue.Queue;
//owner : kaiser sakhi
public class Main {

    public static void main(String[] args) {

        queues();

    }

    static void queues(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(20);
        queue.enqueue(13);
        queue.display();
        System.out.println("Dequeued " + queue.dequeue());
    }
    static void linkedLists(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(88);
        list.add(34);
        list.add(9);
        list.display();
    }
}
