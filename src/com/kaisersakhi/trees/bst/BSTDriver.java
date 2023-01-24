package com.kaisersakhi.trees.bst;

public class BSTDriver{
    public static void main(String[] args) {
//        BinarySearchTree<Character> bst = new BinarySearchTree<>();
//        bst.insert('D');
//        bst.insert('B');
//        bst.insert('F');
//        bst.insert('A');
//        bst.insert('C');
//        bst.insert('E');
//        bst.insert('G');
//        bst.insert('H');
//        bst.delete('A');
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(50);
        bst.insert(25);
        bst.delete(20);
        System.out.println(bst);
        System.out.println("Tree Height is : "+ bst.height());
        System.out.println("Inorder Predecessor : "+bst.inorderPredecessor());
        System.out.println("Item 20 is "+((bst.search(20) != null) ? "Present!" : "Not Present!"));
        System.out.println("Item 25 is "+((bst.search(25) != null) ? "Present!" : "Not Present!"));
    }
}
