package SetAndMap;

import BinarySearchTree.MyBST;

public class MyBSTSet<E extends Comparable<E>> {
    private MyBST<E> bst;

    public MyBSTSet() {
        bst = new MyBST<>();
    }

    public int getSize() {
        return bst.size();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public void add(E e) {
        bst.add(e);
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public void remove(E e) {
        bst.remove(e);
    }
}
