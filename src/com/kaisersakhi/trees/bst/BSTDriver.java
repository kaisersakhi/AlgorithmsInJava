package com.kaisersakhi.trees.bst;

import com.kaisersakhi.trees.binarytrees.BinaryTree;

public class BSTDriver{
    public static void main(String[] args) {
        BinaryTree<Character> bst = new BinarySearchTree<>();
        bst.insert('D');
        bst.insert('B');
        bst.insert('F');
        bst.insert('A');
        bst.insert('C');
        bst.insert('E');
        bst.insert('G');
        System.out.println(bst.inorderTraversal());
    }
}
