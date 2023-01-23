package com.kaisersakhi.trees.binarytrees;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree<>();
        binaryTree.insert('A');
        binaryTree.insert('B');
        binaryTree.insert('C');
        binaryTree.insert('D');
        binaryTree.insert('E');
        binaryTree.insert('F');
        binaryTree.insert('G');
        System.out.println("Preorder : "+binaryTree.preOrderTraversals());
        System.out.println("Postorder : "+binaryTree.postorderTraversal());
        System.out.println("Inorder :"+binaryTree); // default is inorder
        System.out.println("Level Order : "+ binaryTree.levelOrderTraversal());
    }
}
