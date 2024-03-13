package StackAndQueue;

import Arrays.Array;

public class ArrayQueue<E> {
    private Array<E> array;

    // Constructor, pass in the capacity of the array
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    // Default constructor, set the capacity to 10
    public ArrayQueue() {
        array = new Array<>();
    }

    // Get the number of elements in the queue
    public int getSize() {
        return array.getSize();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // Get the capacity of the array
    public int getCapacity() {
        return array.getCapacity();
    }

    // Add an element to the end of the queue
    public void enqueue(E e) {
        array.addLast(e);
    }

    // Remove an element from the beginning of the queue
    public E dequeue() {
        return array.removeFirst();
    }

    // Get the front element of the queue
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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
