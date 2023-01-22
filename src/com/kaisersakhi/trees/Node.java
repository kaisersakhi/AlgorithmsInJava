package com.kaisersakhi.trees;

public class Node <T>{
    public T data;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(){
        leftChild = rightChild = null;
        data = null;
    }
    public Node(T data){
        this.data = data;
        this.leftChild = this.rightChild = null;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
