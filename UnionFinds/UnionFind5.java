package UnionFinds;

public class UnionFind5 implements UF {
    private int[] parent; // The parent of the element i is parent[i]
    private int[] rank; // rank[i] is the number of elements in the Collection of the element i

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int getSize() {
        return parent.length;
    }

    // Find the Collection of the element p
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while (p != parent[p]) {
            p = parent[p];
            parent[p] = parent[parent[p]]; // Path compression
        }

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

        // Merge the Collection of the element p with the Collection of the element q
        // The Collection of the element with the smaller rank is merged into the Collection of the element with the larger rank
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else { // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }

    }
}

