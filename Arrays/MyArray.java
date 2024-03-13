package Arrays;

public class MyArray<E> {
    private E[] data;

    private int size;

    // Constructor, pass in the capacity of the array
    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // Default constructor, set the capacity to 10
    public MyArray() {
        this(10);
    }

    // Get the number of elements in the array
    public int getSize() {
        return size;
    }

    // Get the capacity of the array
    public int getCapacity() {
        return data.length;
    }

    // Check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add an element to the beginning of the array
    public void addFirst(E e) {
        add(0, e);
    }

    // Add an element to the end of the array
    public void addLast(E e) {
        add(size, e);
    }

    // Add an element to the beginning of the array
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size.");

        if (size == data.length)
            resize(2 * data.length); // Double the size of the array

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Get the element at the index
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    // Get the last element
    public E getLast() {
        return get(size - 1);
    }

    // Get the first element
    public E getFirst() {
        return get(0);
    }

    // Set the element at the index
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");

        data[index] = e;
    }

    // Check if the array contains the element
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }

        return false;
    }

    // Find the index of the element
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }

        return -1;
    }

    // Remove the element at the index
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    // Remove the first element
    public E removeFirst() {
        return remove(0);
    }

    // Remove the last element
    public E removeLast() {
        return remove(size - 1);
    }

    // Remove the element
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));

        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<Integer>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);

        System.out.println(arr);

        arr.add(1, 20);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(9);
        System.out.println(arr);
    }
}