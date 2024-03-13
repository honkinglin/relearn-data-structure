package StackAndQueue;

import LinkedList.MyLinkedList;

public class MyLinkedListStack<E> {
    private MyLinkedList<E> list;

    public MyLinkedListStack() {
        list = new MyLinkedList<>();
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

    public static void main(String[] args) {
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
