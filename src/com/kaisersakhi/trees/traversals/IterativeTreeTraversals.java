package com.kaisersakhi.trees.traversals;

import com.kaisersakhi.queue.Queue;
import com.kaisersakhi.stack.Stack;
import com.kaisersakhi.trees.Node;

public class IterativeTreeTraversals<T extends Comparable<T>> {

    public void levelOrder(Node<T> node, StringBuilder stringBuilder){
        if (node == null) return;
        Queue<Node<T>> queue = new Queue<>();
        queue.enqueue(node);
        Node<T> current;
        while(queue.isNotEmpty()){
            current = queue.dequeue();
            stringBuilder.append(current.data);
            stringBuilder.append(", ");
            if (current.leftChild != null) queue.enqueue(current.leftChild);
            if (current.rightChild != null) queue.enqueue(current.rightChild);
        }
    }

    public void preorder(Node<T> node, StringBuilder stringBuilder){
        if (node == null) return;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(node);
        Node<T> current;
        while(stack.isNotEmpty()){
            current = stack.pop();
            if (current != null) {
                stringBuilder.append(current.data);
                stringBuilder.append(", ");

                if (current.rightChild != null) stack.push(current.rightChild);
                if (current.leftChild != null) stack.push(current.leftChild);
            }
        }
    }

    public void inorder(Node<T> node, StringBuilder stringBuilder){
        if (node == null) return;
        Stack<Node<T>> stack = new Stack<>();
//        stack.push();
        Node<T> current = node;

        while(current != null || stack.isNotEmpty()){

            while(current != null){
                stack.push(current);
                current = current.leftChild;
            }
            current = stack.pop();
            stringBuilder.append(current.data);
            stringBuilder.append(", ");
//            if (current.rightChild != null) stack.push(current.rightChild);
            current = current.rightChild;
        }
    }

    public void postorder(Node<T> node, StringBuilder stringBuilder){
        if (node == null) return;
        Stack<Node<T>> stack = new Stack<>();
        Node<T> previous = null;
        Node<T> current = node;

        while(current != null || stack.isNotEmpty()){
            if (current != null){
                stack.push(current);
                current = current.leftChild;
            }else{
                current = stack.peek();
                if (current.rightChild == null || current.rightChild == previous){
                    stringBuilder.append(current.data);
                    stringBuilder.append(", ");
                    previous = current;
                    current = null;
                    stack.pop();
                }else{
                    current = current.rightChild;
                }
            }
        }
    }
}
