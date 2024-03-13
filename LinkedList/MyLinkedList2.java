package LinkedList;

public class MyLinkedList2<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public MyLinkedList2() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // add element at index
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            // find the previous node of index
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;

            prev.next = new Node(e, prev.next);
            size++;
        }

    }

    // add element at first
    public void addFirst(E e) {
        Node newNode = new Node(e, head);
        head = newNode;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    // get element at index
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // set element at index
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = head;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = head;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        Node prev = head;
        // find the previous node of index
        for (int i = 0; i < index - 1; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = prev.next.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.addFirst(i);
            System.out.println(myLinkedList);
        }

        myLinkedList.add(2, 666);
        System.out.println(myLinkedList);

        myLinkedList.remove(2);
        System.out.println(myLinkedList);

        myLinkedList.removeFirst();
        System.out.println(myLinkedList);

        myLinkedList.removeLast();
        System.out.println(myLinkedList);
    }
}
