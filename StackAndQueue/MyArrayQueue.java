package StackAndQueue;

import Arrays.MyArray;

public class MyArrayQueue<E> {
    private MyArray<E> myArray;

    // Constructor, pass in the capacity of the array
    public MyArrayQueue(int capacity) {
        myArray = new MyArray<>(capacity);
    }

    // Default constructor, set the capacity to 10
    public MyArrayQueue() {
        myArray = new MyArray<>();
    }

    // Get the number of elements in the queue
    public int getSize() {
        return myArray.getSize();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    // Get the capacity of the array
    public int getCapacity() {
        return myArray.getCapacity();
    }

    // Add an element to the end of the queue
    public void enqueue(E e) {
        myArray.addLast(e);
    }

    // Remove an element from the beginning of the queue
    public E dequeue() {
        return myArray.removeFirst();
    }

    // Get the front element of the queue
    public E getFront() {
        return myArray.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < myArray.getSize(); i++) {
            res.append(myArray.get(i));
            if (i != myArray.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
