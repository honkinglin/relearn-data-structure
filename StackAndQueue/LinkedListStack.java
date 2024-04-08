package StackAndQueue;

import LinkedLists.LinkedList;

public class LinkedListStack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        // addFirst() in MyLinkedList is O(1)
        list.addFirst(e);
    }

    public E pop() {
        // removeFirst() in MyLinkedList is O(1)
        return list.removeFirst();
    }

    public E peek() {
        // getFirst() in MyLinkedList is O(1)
        return list.getFirst();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
