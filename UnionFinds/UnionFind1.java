package UnionFinds;

public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    public int getSize() {
        return id.length;
    }

    // Find the Collection of the element p
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");

        while (p != id[p])
            p = id[p];

        return p;
    }

    // Merge the Collection of the element p with the Collection of the element q
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        // Merge the Collection of the element p with the Collection of the element q
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
    }
}
