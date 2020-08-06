package com.kaisersakhi;
import com.kaisersakhi.linkedlist.LinkedList;
import com.kaisersakhi.queue.Queue;
import com.kaisersakhi.trees.BinaryTree;
import com.kaisersakhi.trees.BinarySearchTree;
//owner : kaiser sakhi

/*
    Note : This code is not written by a CS professional but a CS Grad. i hosted this code on github because i wannted to get
            taste of git , the code is totally written in simple way possible . if you're learning data structures and algorithms ,
            this might be useful for you.
            :this code is highly infulanced by {  Abdul Bari (Great Teacher) }
                    link of his youtube channel : https://www.youtube.com/channel/UCZCFT11CWBi3MHNlGf019nw

             if you find this code helpful in anyway than probally you should star it.

             im working on python also side by side - learning Python ;)

 */
public class Main {

    public static void main(String[] args) {

//        queues();
//        binaryTree();
        bst();
    }

    static void queues(){
        Queue<Double> queue = new Queue<>();
        queue.enqueue(10.90786533);
        queue.enqueue(2.23);
        queue.enqueue(450.3);
        queue.enqueue(13.22222);
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

    static void binaryTree(){
        var tree = new BinaryTree<Integer>();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

//        tree.preOrder();
        tree.levelOrder();


//        System.out.println(tree.root.lchild.lchild.data);
        System.out.println("The count is "+ tree.count());
    }

    static void bst(){
        var bst = new BinarySearchTree<Integer>();
        bst.insert(20);
        bst.insert(18);
        bst.add(23);
        bst.add(10);
//        bst.levelOrder();
//        bst.preOrder();
        bst.inOrder();
        System.out.println("Count is :"+bst.count());
    }
}
