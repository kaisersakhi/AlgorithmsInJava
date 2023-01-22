package com.kaisersakhi.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    SinglyLinkedList(SinglyLinkedList<T> otherList) {
        if (otherList.size() < 1) return;
        this.size = otherList.size;
        this.head = new ListNode<T>(otherList.head.data);

        ListNode<T> currentOther = otherList.head.next;
        ListNode<T> current = head;

        while (currentOther != null) {
            current.next = new ListNode<>(currentOther.data);
            current = current.next;
            currentOther = currentOther.next;
        }
    }

    public void append(T data) {
        if (this.head == null) {
            this.head = new ListNode<>(data);
            ++this.size;
            return;
        }
        ListNode<T> current = this.head;
        while (current.next != null) current = current.next;
        current.next = new ListNode<>(data);
        ++this.size;
    }

    public void prepend(T data) {
        if (this.head == null) {
            this.head = new ListNode<>(data);
            ++this.size;
            return;
        }
        ListNode<T> newNode = new ListNode<>(data);
        newNode.next = this.head;
        this.head = newNode;
        ++size;
    }

    public T pop() {
        T data = null;
        if (this.size == 1) {
            data = this.head.data;
            --this.size;
            return data;
        }
        ListNode<T> current = this.head;
        ListNode<T> previous = head;
        while (current != null) {
            if (current.next == null) {
                data = current.data;
                previous.next = null;
                --this.size;
                break;
            }
            previous = current;
            current = current.next;
        }
        return data;
    }

    public T popHead(){
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        --size;
        return data;
    }

    public void delete(T dataItem) {
        if (head == null) return;
        if (head.data == dataItem) {
            head = head.next;
            return;
        }

        ListNode<T> previous = head;
        ListNode<T> current = head;

        while (current != null) {
            if (current.data == dataItem) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public ListNode<T> find(T itemData) {
        ListNode<T> current = this.head;
        while (current != null) {
            if (current.data == itemData) return current;
            current = current.next;
        }
        return null;
    }

    //this method will use "Move To Head" method
    // make the searched node head of the list
    public ListNode<T> findImprovise(T dataItem) {
        if (this.size == 0) return null;
        if (this.head.data == dataItem)
            return new ListNode<>(head.data);

        ListNode<T> current = this.head;
        ListNode<T> previous = current;

        while (current != null) {
            if (current.data == dataItem) {
                previous.next = current.next;
                current.next = head;
                head = current;
                return new ListNode<>(head.data);
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        ListNode<T> current = this.head;
        string.append("[");
        while (current != null) {
            string.append(current.data.toString());
            if (current.next != null) {
                string.append(", ");
            }
            current = current.next;
        }
        string.append("]");
        return string.toString();
    }

    public SinglyLinkedList<T> reverse() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>(this);
        if (size < 2) return copy;

        ListNode<T> previous = null;
        ListNode<T> current = copy.head;
        ListNode<T> next = current.next;

        while (true) {
            current.next = previous;
            previous = current;
            if (next == null) {
                copy.head = current;
                break;
            }
            current = next;
            next = next.next;

        }
        return copy;
    }

    public boolean isHavingLoop(){
        if (this.size < 1) return false;
        Set<ListNode<T>> set = new HashSet<>();

        ListNode<T> current = head;

        while(current != null){
            if (!set.add(current)) return false;
            current = current.next;
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    public T getHead() {
        if (head == null) return null;
        return head.data;
    }
}
