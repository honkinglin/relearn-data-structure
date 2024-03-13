package StackAndQueue;

import Arrays.MyArray;

public class MyArrayStack<E> {
    MyArray<E> myArray;

    public MyArrayStack(int capacity) {
        myArray = new MyArray<>(capacity);
    }

    public MyArrayStack() {
        myArray = new MyArray<>();
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

    public static void main(String[] args) {
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
