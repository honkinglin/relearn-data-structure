package Arrays;

public class Test {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);

        System.out.println(arr);

        arr.add(1, 20);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(9);
        System.out.println(arr);
    }
}
