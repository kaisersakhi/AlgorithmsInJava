package com.kaisersakhi.trees.traversals;

import com.kaisersakhi.trees.Node;

public class RecursiveTreeTraversals<T> {
    public void preorder(Node<T> node, StringBuilder stringBuilder) {
        if (node != null) {
            stringBuilder.append(node.data);
            stringBuilder.append(", ");
            preorder(node.leftChild, stringBuilder);
            preorder(node.rightChild, stringBuilder);
        }
    }

    public void inorder(Node<T> node, StringBuilder stringBuilder) {
        if (node != null) {
            inorder(node.leftChild, stringBuilder);
            stringBuilder.append(node.data);
            stringBuilder.append(", ");
            inorder(node.rightChild, stringBuilder);
        }
    }

    public void postorder(Node<T> node, StringBuilder stringBuilder) {
        if (node != null) {
            postorder(node.leftChild, stringBuilder);
            postorder(node.rightChild, stringBuilder);
            stringBuilder.append(node.data);
            stringBuilder.append(", ");
        }
    }
}
