package com.kaisersakhi.trees;

public class BinaryTreeHelper<T extends Comparable<T>> {
    public Node<T> delete(Node<T> node, T key, int[] hasBeenDeleted){
        Node<T> temp = null;

        if (node == null)
            return null;

        if (isLeafNode(node)) return null;

        if (key.compareTo(node.data) > 0){
            node.rightChild = delete(node.rightChild, key, hasBeenDeleted);
        }else if (key.compareTo(node.data) < 0){
            node.leftChild = delete(node.leftChild, key, hasBeenDeleted);
        }else{
            hasBeenDeleted[0] = 1;
            if (height(node.leftChild) > height(node.rightChild)){
                temp = inorderPredecessor(node);
                node.data = temp.data;
                node.leftChild = delete(node.leftChild, temp.data, hasBeenDeleted);
            }else{
                temp = inorderSuccessor(node);
                node.data = temp.data;
                node.rightChild = delete(node.rightChild, temp.data, hasBeenDeleted);
            }
        }
        return node;
    }

    public int height(Node<T> node){
        if (node != null){
            int x, y;
            x = height(node.leftChild);
            y = height(node.rightChild);
            return x > y ? x + 1 : y + 1;
        }
        return 0;
    }

    public Node<T> inorderPredecessor(Node<T> node){
        if (node.leftChild != null){
            node = node.leftChild;
            while (node.rightChild != null)
                node = node.rightChild;
        }
        return node;
    }

    public Node<T> inorderSuccessor(Node<T> node){
        if (node.rightChild != null){
            node = node.rightChild;
            while (node.leftChild != null)
                node = node.leftChild;
        }
        return node;
    }

    public boolean isLeafNode(Node<T> node){
        return node != null && node.leftChild == null && node.rightChild == null;
    }

    public Node<T> search(Node<T> node, T key){
        if (node == null) return null;
        Node<T> current = node;
        while (current != null){
            if (current.compareTo(key) > 0){ // key is less, goto left side
                current = current.leftChild;
            }else if (current.compareTo(key) < 0){
                current = current.rightChild;
            }else{
                return new Node<>(current.data);
            }
        }
        return null;
    }
}
