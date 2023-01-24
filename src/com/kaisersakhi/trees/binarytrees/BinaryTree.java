package com.kaisersakhi.trees.binarytrees;

import com.kaisersakhi.queue.Queue;
import com.kaisersakhi.trees.BinaryTreeHelper;
import com.kaisersakhi.trees.ITree;
import com.kaisersakhi.trees.Node;
import com.kaisersakhi.trees.traversals.IterativeTreeTraversals;
import com.kaisersakhi.trees.traversals.RecursiveTreeTraversals;

public class BinaryTree<T extends Comparable<T>> implements ITree<T> {
    private final Queue<Node<T>> queue;
    protected int size;

    protected Node<T> root;

    protected final RecursiveTreeTraversals<T> recursiveTreeTraversals;
    protected final IterativeTreeTraversals<T> iterativeTreeTraversals;
    protected final BinaryTreeHelper<T> helper;

    public BinaryTree() {
        this.queue = new Queue<>();
        this.size = 0;
        this.root = null;

        this.recursiveTreeTraversals = new RecursiveTreeTraversals<>();
        this.iterativeTreeTraversals = new IterativeTreeTraversals<>();

        this.helper = new BinaryTreeHelper<>();
    }

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            ++size;
            queue.enqueue(root);
            return;
        }
        Node<T> current = queue.peekFront();
        assert current != null;
        if (current.leftChild == null) {
            current.leftChild = new Node<>(data);
            queue.enqueue(current.leftChild);
        } else if (current.rightChild == null) {
            current.rightChild = new Node<>(data);
            queue.enqueue(current.rightChild);
            queue.dequeue();
        }
        ++size;
    }

    @Override
    public String toString() {
        return inorderTraversal();
    }

    public String preOrderTraversals() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
//        recursiveTreeTraversals.preorder(this.root, stringBuilder);
        iterativeTreeTraversals.preorder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String inorderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
//        recursiveTreeTraversals.inorder(this.root, stringBuilder);
        iterativeTreeTraversals.inorder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String postorderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
//        recursiveTreeTraversals.postorder(this.root, stringBuilder);
        iterativeTreeTraversals.postorder(this.root, stringBuilder);
        if (stringBuilder.length() > 2)
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String levelOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        iterativeTreeTraversals.levelOrder(this.root, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public int height() {
        if (root == null) return 0;
        return helper.height(root);
    }

    public T inorderPredecessor() {
        if (root == null) return null;
        return helper.inorderPredecessor(root).data;
    }

    public T inorderSuccessor() {
        if (root == null) return null;
        return helper.inorderSuccessor(root).data;
    }
}
