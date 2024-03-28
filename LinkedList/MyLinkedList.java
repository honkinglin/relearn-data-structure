package LinkedList;

public class MyLinkedList<E> {
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

    // virtual head node
    private Node dummyHead;
    private int size;

    public MyLinkedList() {
        dummyHead = new Node(null, null);
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

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    // add element at first
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    // get element at index
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
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

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
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

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
//            res.append(cur + "->");

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
