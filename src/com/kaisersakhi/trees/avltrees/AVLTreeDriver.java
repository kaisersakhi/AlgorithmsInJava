package com.kaisersakhi.trees.avltrees;

public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(4);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(90);
        avlTree.insert(100);
        System.out.println(avlTree);
        System.out.println("Level Order Traversal : " + avlTree.levelOrderTraversal());
        System.out.println("AVL Tree Height is : " + avlTree.height());
    }
}
