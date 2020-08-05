package com.kaisersakhi.trees;

//Owner : Kaiser Sakhi
import com.kaisersakhi.trees.Node;
import com.kaisersakhi.queue.Queue;
public class BinaryTree<Type> {
    //this member will store the root node of tree
    Node<Type> root;
    //this queue will be used to insert node into tree
    Queue<Node> queue;
    //this will store number of nodes in a tree
    int size;

    //this contructor will init the queue
    public BinaryTree(){
        root = null;
        queue = new Queue<>();
        size = 0;
    }

    //this methods add a new node to the binary tree
    public void add(Type data){
        //crate new node of Type and pass the data object
        Node<Type> node = new Node<>(data);
        //if root is null means tree does not exits yet
        if (root == null){
            //the assingn this new node , as this is the first node in the tree , to root node
            root = node;
            //and enqueue the root , so that we can fill up its children next time we have to add a node
            queue.enqueue(root);
            size++;
            //else if , the root is not null then queue must node be empty ,
            //because there has to be nodes in a tree whose children has to be filled
        }else if (!queue.isEmpty()){
            //get the node , whose children will be attacted ,
            Node front = this.queue.getFrontData();
            //if the node whose left child is null ,as we are insertin in level order , attach this new node to it
            if (front.lchild == null){
                front.lchild = node;
                //else if right node is null
            }else if (front.rchild == null){
                front.rchild = node;
                //also delete that node whose children , left and right , we have filled
                this.queue.dequeue();

            }
            //enqueue the current node , becuse we have to fill its children later
            this.queue.enqueue(node);
            size++;

        }
    }

    //this is a private recursive function
    private void pre_order(Node root){
        //if root , current node , is null then return
        if (root==null) return;
        //if the root is not null then print its data
        System.out.println(root.data);
        //and call on it left child
        pre_order(root.lchild);
        //then call on its right child
        pre_order(root.rchild);
    }
    //this is the public mirror method of pre_order
    public void preOrder(){
        pre_order(root);
    }

    //this is an iterative method for level order traversal
    public void levelOrder(){
        //first make a queue
        Queue<Node> q = new Queue<>();
        //enqueue the root
        q.enqueue(this.root);
        //until queue is not empty , loop
        while ( !q.isEmpty()){
            //get the node form the front of the queue , at first it will be root of the tree
            Node current = q.getFrontData();
            //if the node is not null
            if (current != null) {
                //then print the data
                System.out.println(current.data);
                //also if its left child is not null then enquque because i dont wanna insert null into queueue
                if (current.lchild != null)
                    q.enqueue(current.lchild);
                //same with this
                if (current.rchild != null)
                    q.enqueue(current.rchild);
                //i have , printed the data of the current node and also enqueued its children
                //after this the node should not be in the queueu  , because we visited its left , aright and processed its data
                q.dequeue();
            }
        }
    }


    private int count_(Node node){
        int x = 0,y = 0;
        if (node != null){
            x = count_(node.lchild);
            y = count_(node.rchild);
            return x + y +1;
//            if (x > y){
//                return x + 1;
//            }else{
//                return y + 1;
//            }
        }
        return 0;
    }

    public int count(){
        return count_(this.root);
    }
}
