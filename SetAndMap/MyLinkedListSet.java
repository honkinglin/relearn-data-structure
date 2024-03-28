package SetAndMap;

import LinkedList.MyLinkedList;

public class MyLinkedListSet<E> {
    private MyLinkedList<E> list;

    public MyLinkedListSet() {
        list = new MyLinkedList<>();
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
