package com.kaisersakhi.trees.bst;

import com.kaisersakhi.trees.Node;
import com.kaisersakhi.trees.binarytrees.BinaryTree;

//1<^1S3R
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    public BinarySearchTree() {
        super();
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(T data) {
        if (this.root == null) {
            super.insert(data);
            return;
        }

        Node<T> current = this.root;
        Node<T> previous = null;

        while (current != null){

            if (current.data.compareTo(data) > 0){ // newData is less then root
                previous = current;
                current = current.leftChild;
            }else if (current.data.compareTo(data) < 0){
                previous = current;
                current = current.rightChild;
            }else{
                return; // data is already present
            }
        }
        if (previous.data.compareTo(data) > 0){
            previous.leftChild = new Node<>(data);
        }else{
            previous.rightChild = new Node<>(data);
        }
        ++this.size;
    }

    public void delete(T key){
        if (root == null) return;
        int[] hasBeenDeleted = new int[1];
        super.helper.delete(root, key, hasBeenDeleted);
        if(hasBeenDeleted[0] == 1){
            --super.size;
        }
    }

    public T search(T key){
        Node<T> temp =  helper.search(root, key);
        if (temp != null)
            return temp.data;
        return null;
    }

}
