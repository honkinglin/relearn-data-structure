package StackAndQueue;

import Arrays.Array;

public class ArrayStack<E> {
    Array<E> myArray;

    public ArrayStack(int capacity) {
        myArray = new Array<>(capacity);
    }

    public ArrayStack() {
        myArray = new Array<>();
    }

    public int getSize() {
        return myArray.getSize();
    }

    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    public int getCapacity() {
        return myArray.getCapacity();
    }

    public void push(E e) {
        myArray.addLast(e);
    }

    public E pop() {
        return myArray.removeLast();
    }

    public E peek() {
        return myArray.getLast();
    }

    // Override the toString method
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < myArray.getSize(); i++) {
            res.append(myArray.get(i));
            if (i != myArray.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");

        return res.toString();
    }
}
