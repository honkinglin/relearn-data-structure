package UnionFind;

public class UnionFind2 implements UF {
    // The parent of the element i is parent[i]
    // The meaning of the parent[i] is the parent of the element i
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    public int getSize() {
        return parent.length;
    }

    // Find the Collection of the element p
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while (p != parent[p])
            p = parent[p];

        return p;
    }

    // Merge the Collection of the element p with the Collection of the element q
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }
}
