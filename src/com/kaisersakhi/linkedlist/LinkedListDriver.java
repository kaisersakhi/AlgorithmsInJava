package com.kaisersakhi.linkedlist;

public class LinkedListDriver {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.prepend(0);
        list.delete(3);
//        list.pop();
        list.findImprovise(3);
//        list.findImprovise(5);
//
//        System.out.println(list.reverse());
//        System.out.println(list.isHavingLoop());

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.prepend(0);
//        doublyLinkedList.pop();
//        doublyLinkedList.pop();
        doublyLinkedList.pop();
        doublyLinkedList.popHead();
        System.out.println(doublyLinkedList);
    }
}
