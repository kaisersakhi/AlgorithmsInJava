package com.kaisersakhi.trees;

import org.jetbrains.annotations.NotNull;

public class Node <T extends Comparable<T>> implements Comparable<T>{
    public T data;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public byte height;
    public Node(){
        leftChild = rightChild = null;
        data = null;
        height = 1;
    }
    public Node(T data){
        this.data = data;
        this.leftChild = this.rightChild = null;
        height = 1;
    }

    @Override
    public String toString(){
        return data.toString();
    }


    @Override
    public int compareTo(@NotNull T o) {
        return this.data.compareTo(o);
    }
}
