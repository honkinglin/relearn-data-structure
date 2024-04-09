package AVLTrees;

import SetAndMap.Map;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avl;

    public AVLMap() {
        avl = new AVLTree<>();
    }

    public void add(K key, V value) {
        avl.add(key, value);
    }

    public V remove(K key) {
        return avl.remove(key);
    }

    public boolean contains(K key) {
        return avl.contains(key);
    }

    public V get(K key) {
        return avl.get(key);
    }

    public void set(K key, V value) {
        avl.set(key, value);
    }

    public int getSize() {
        return avl.getSize();
    }

    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
