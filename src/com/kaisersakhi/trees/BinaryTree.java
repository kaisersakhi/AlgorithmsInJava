package com.kaisersakhi.trees;

import com.kaisersakhi.queue.Queue;
import com.kaisersakhi.trees.traversals.IterativeTreeTraversals;
import com.kaisersakhi.trees.traversals.RecursiveTreeTraversals;

public class BinaryTree<T> implements ITree<T>{
    private final Queue<Node<T>> queue;
    private int size;

    Node<T> root;

    private final RecursiveTreeTraversals<T> recursiveTreeTraversals;
    private final IterativeTreeTraversals<T> iterativeTreeTraversals;

    public BinaryTree(){
        this.queue = new Queue<>();
        this.size = 0;
        this.root = null;

        this.recursiveTreeTraversals = new RecursiveTreeTraversals<>();
        this.iterativeTreeTraversals = new IterativeTreeTraversals<>();
    }

    @Override
    public void insert(T data) {
        if (root == null){
            root = new Node<>(data);
            ++size;
            queue.enqueue(root);
            return;
        }
        Node<T> current = queue.peekFront();
        assert current != null;
        if (current.leftChild == null){
            current.leftChild = new Node<>(data);
            queue.enqueue(current.leftChild);
        }else if (current.rightChild == null){
            current.rightChild = new Node<>(data);
            queue.enqueue(current.rightChild);
            queue.dequeue();
        }
        ++size;
    }

    @Override
    public String toString(){
        return inorderTraversal();
    }

    public String preOrderTraversals(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
//        recursiveTreeTraversals.preorder(this.root, stringBuilder);
        iterativeTreeTraversals.preorder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String inorderTraversal(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
//        recursiveTreeTraversals.inorder(this.root, stringBuilder);
        iterativeTreeTraversals.inorder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String postorderTraversal(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        recursiveTreeTraversals.postorder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String levelOrderTraversal(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        iterativeTreeTraversals.levelOrder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
