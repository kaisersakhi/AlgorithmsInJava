package com.kaisersakhi.trees.avltrees;

import com.kaisersakhi.trees.bst.BinarySearchTree;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public void insert(T  data){
        int[] hasBeenInserted = new int[1];
        root = helper.recursiveInsertWithBalancingFactor(root, data, hasBeenInserted);
        if (hasBeenInserted[0] == 1) ++size;
    }
}
