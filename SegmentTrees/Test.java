package SegmentTrees;

public class Test {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);

        System.out.println(segTree.getSize());
        System.out.println(segTree.get(0));
        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));

        segTree.set(0, 1);
        System.out.println(segTree.query(0, 2));
    }
}
