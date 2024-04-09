package AVLTrees;

import SetAndMap.Set;

public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    public int getSize() {
        return avl.getSize();
    }

    public boolean isEmpty() {
        return avl.isEmpty();
    }

    public void add(E e) {
        avl.add(e, null);
    }

    public boolean contains(E e) {
        return avl.contains(e);
    }

    public void remove(E e) {
        avl.remove(e);
    }
}
