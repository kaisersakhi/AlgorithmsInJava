package com.kaisersakhi.trees;
import com.kaisersakhi.trees.Node;
import com.sun.jdi.Value;
/*
*   #OWNER :- KAISER SAKHI
* */

public class BinarySearchTree<Type> extends BinaryTree<Type>{

    public BinarySearchTree(){
        //these are the members of the superclass
        //setting queue to null because i dont require it to add node in level order fashion
        //rather i
        this.queue = null;
        this.size = 0;
        this.root  = null;
    }
    //this method only works with Wrapper class on int as i have to compare the data
    @Override
    public void add(Type data){
        Node<Type> node = new Node<>(data);
        if (data instanceof Integer)
            if (this.root == null){
                this.root = node;
                ++this.size;
            }else{
                Node<Type> current = this.root;

                while (current != null){
                    if (Integer.parseInt(data.toString()) < Integer.parseInt(current.data.toString())){
                        if (current.lchild == null)
                            break;
                        current = current.lchild;
                    }else if (Integer.parseInt(data.toString()) > Integer.parseInt(current.data.toString())){
                        if (current.rchild == null)
                            break;
                        current = current.rchild;
                    }else if (Integer.parseInt(data.toString()) == Integer.parseInt(current.data.toString())){
                        return;
                    }
                }


                if (Integer.parseInt(data.toString()) < Integer.parseInt(current.data.toString())){
                    current.lchild = node;
                }else if (Integer.parseInt(data.toString()) > Integer.parseInt(current.data.toString())){
                    current.rchild = node;
                }

                this.size++;


            }
    }
    /*
    * this method is a recursive method which will attach a node to the bst in a recursive fashion
    * */
    private Node<Type> insert_recursive(Node<Type> node , Type data){
        if (node == null){
            node = new Node<>(data);
            this.size++;
            return node;
        }else {
            if (Integer.parseInt(data.toString()) < Integer.parseInt(node.data.toString())){
                node.lchild = insert_recursive(node.lchild , data);
            }else if (Integer.parseInt(data.toString()) > Integer.parseInt(node.data.toString())){
                node.rchild = insert_recursive(node.rchild , data);
            }
        }
        return node;
    }

    public void insert(Type data){
        this.root = insert_recursive(this.root , data);
    }
}
