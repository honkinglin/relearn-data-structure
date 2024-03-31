package HeapAndPriorityQueue;

public class MyPriorityQueue<E extends Comparable<E>> {
    private MyMaxHeap<E> maxHeap;

    public MyPriorityQueue() {
        maxHeap = new MyMaxHeap<>();
    }

    public int getSize() {
        return maxHeap.getSize();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public E getFront() {
        return maxHeap.findMax();
    }

    public void enqueue(E e) {
        maxHeap.add(e);
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }
}
