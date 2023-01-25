package com.kaisersakhi.trees;

public class BinaryTreeHelper<T extends Comparable<T>> {
    public Node<T> delete(Node<T> node, T key, int[] hasBeenDeleted) {
        Node<T> temp = null;

        if (node == null)
            return null;

        if (isLeafNode(node)) return null;

        if (key.compareTo(node.data) > 0) {
            node.rightChild = delete(node.rightChild, key, hasBeenDeleted);
        } else if (key.compareTo(node.data) < 0) {
            node.leftChild = delete(node.leftChild, key, hasBeenDeleted);
        } else {
            hasBeenDeleted[0] = 1;
            if (height(node.leftChild) > height(node.rightChild)) {
                temp = inorderPredecessor(node);
                node.data = temp.data;
                node.leftChild = delete(node.leftChild, temp.data, hasBeenDeleted);
            } else {
                temp = inorderSuccessor(node);
                node.data = temp.data;
                node.rightChild = delete(node.rightChild, temp.data, hasBeenDeleted);
            }
        }
        return node;
    }

    public int height(Node<T> node) {
        if (node != null) {
            int x, y;
            x = height(node.leftChild);
            y = height(node.rightChild);
            return x > y ? x + 1 : y + 1;
        }
        return 0;
    }

    public Node<T> inorderPredecessor(Node<T> node) {
        if (node.leftChild != null) {
            node = node.leftChild;
            while (node.rightChild != null)
                node = node.rightChild;
        }
        return node;
    }

    public Node<T> inorderSuccessor(Node<T> node) {
        if (node.rightChild != null) {
            node = node.rightChild;
            while (node.leftChild != null)
                node = node.leftChild;
        }
        return node;
    }

    public boolean isLeafNode(Node<T> node) {
        return node != null && node.leftChild == null && node.rightChild == null;
    }

    public Node<T> search(Node<T> node, T key) {
        if (node == null) return null;
        Node<T> current = node;
        while (current != null) {
            if (current.compareTo(key) > 0) { // key is less, goto left side
                current = current.leftChild;
            } else if (current.compareTo(key) < 0) {
                current = current.rightChild;
            } else {
                return new Node<>(current.data);
            }
        }
        return null;
    }

    public Node<T> recursiveInsert(Node<T> node, T data, int[] hasBeenInserted) {
        if (node == null) {
            hasBeenInserted[0] = 1;
            return new Node<>(data);
        }

        if (node.data.compareTo(data) < 0) {
            node.rightChild = recursiveInsert(node.rightChild, data, hasBeenInserted);
        } else if (node.data.compareTo(data) > 0) {
            node.leftChild = recursiveInsert(node.leftChild, data, hasBeenInserted);
        }
        return node;
    }


    public Node<T> recursiveInsertWithBalancingFactor(Node<T> node, T data, int[] hasBeenInserted) {
        if (node == null) {
            hasBeenInserted[0] = 1;
            return new Node<>(data);
        }
        //go to right child if key is greater
        if (node.data.compareTo(data) < 0) {
            node.rightChild = recursiveInsertWithBalancingFactor(node.rightChild, data, hasBeenInserted);
        } else if (node.data.compareTo(data) > 0) {
            node.leftChild = recursiveInsertWithBalancingFactor(node.leftChild, data, hasBeenInserted);
        }
        //recompute node height
        node.height = getNodeHeight(node);

        if (getBalancingFactor(node) == 2 && getBalancingFactor(node.leftChild) == 1) {
            //LLRotation
            return performLLRotation(node);
        } else if (getBalancingFactor(node) == 2 && getBalancingFactor(node.leftChild) == -1) {
            //LRRotation
            return performLRRotation(node);
        } else if (getBalancingFactor(node) == -2 && getBalancingFactor(node.rightChild) == -1) {
            //RRRotation
            return performRRRotation(node);
        } else if (getBalancingFactor(node) == -2 && getBalancingFactor(node.rightChild) == 1) {
            //RLRotation
            return performRLRotation(node);
        }

        return node;
    }

    private byte getNodeHeight(Node<T> node) {
        byte leftHeight = (node.leftChild != null) ? node.leftChild.height : 0;
        byte rightHeight = (node.rightChild != null) ? node.rightChild.height : 0;
        return (byte) (leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1);
    }

    public byte getBalancingFactor(Node<T> node) {
        if (node == null) return (byte) 0;
        byte leftHeight = (node.leftChild != null) ? node.leftChild.height : 0;
        byte rightHeight = (node.rightChild != null) ? node.rightChild.height : 0;
        return (byte) (leftHeight - rightHeight);
//        return node.height;
    }

    public Node<T> performLLRotation(Node<T> node) {
        System.out.println("Performing LL-Rotation on node "+node);
        Node<T> newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        newRoot.height = getNodeHeight(newRoot);
        node.height = getNodeHeight(node);
        return newRoot;
    }

    public Node<T> performLRRotation(Node<T> node) {
        System.out.println("Performing LR-Rotation on node "+node);
        Node<T> leftNode = node.leftChild;
        Node<T> newRoot = leftNode.rightChild;
        node.leftChild = newRoot.rightChild;
        leftNode.rightChild = newRoot.leftChild;
        newRoot.leftChild = leftNode;
        newRoot.rightChild = node;
        newRoot.rightChild.height = getNodeHeight(newRoot.rightChild);
        leftNode.height = getNodeHeight(leftNode);
        newRoot.height = getNodeHeight(newRoot);
        return newRoot;
    }

    public Node<T> performRRRotation(Node<T> node) {
        System.out.println("Performing RR-Rotation on node "+node);
        Node<T> newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        newRoot.leftChild.height = getNodeHeight(newRoot.leftChild);
        newRoot.height = getNodeHeight(newRoot);
        return newRoot;
    }

    public Node<T> performRLRotation(Node<T> node) {
        System.out.println("Performing RL-Rotation on node "+node);
        Node<T> rightNode = node.rightChild;
        Node<T> newRoot = rightNode.leftChild;
        node.rightChild = newRoot.leftChild;
        rightNode.leftChild = newRoot.rightChild;
        newRoot.leftChild = node;
        newRoot.rightChild = rightNode;

        node.height = getNodeHeight(node);
        rightNode.height = getNodeHeight(rightNode);
        newRoot.height = getNodeHeight(newRoot);


        return newRoot;
    }

}
