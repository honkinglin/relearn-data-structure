package HeapAndPriorityQueue;

public class PriorityQueue<E extends Comparable<E>> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
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
