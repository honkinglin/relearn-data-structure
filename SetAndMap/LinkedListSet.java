package SetAndMap;

import LinkedLists.LinkedList;

public class LinkedListSet<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public void add(E e) {
        if (!list.contains(e))
            list.addFirst(e);
    }

    public void remove(E e) {
        list.removeElement(e);
    }
}
