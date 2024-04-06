package UnionFind;

public class TestUF {
    public static void main(String[] args) {
        int size = 20000000;
        int m = 20000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1: " + testUF(uf1, m) + " s");

//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2: " + testUF(uf2, m) + " s");

        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3: " + testUF(uf3, m) + " s");

        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4: " + testUF(uf4, m) + " s");

        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5: " + testUF(uf5, m) + " s");

        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6: " + testUF(uf6, m) + " s");
    }

    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = (int) (Math.random() * size);
            int b = (int) (Math.random() * size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = (int) (Math.random() * size);
            int b = (int) (Math.random() * size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
