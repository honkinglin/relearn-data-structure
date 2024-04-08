package SetAndMap;

import BinarySearchTree.BST;

public class BSTSet<E extends Comparable<E>> {
    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
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
