package UnionFinds;

public class UnionFind3 implements UF {
    private int[] parent; // The parent of the element i is parent[i]
    private int[] sz; // sz[i] is the number of elements in the Collection of the element i

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
