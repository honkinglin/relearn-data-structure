package Trie;

public class Test {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        String filename = "PrideAndPrejudice.txt";
        java.util.ArrayList<String> words = new java.util.ArrayList<>();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        // TreeSet test
        long startTime = System.nanoTime();
        java.util.TreeSet<String> set = new java.util.TreeSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if (!set.contains(word)) {
                throw new RuntimeException("Error");
            }
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Total different words: " + set.size());
        System.out.println("TreeSet: " + time + " s");

        System.out.println("---------------------------------");

        // MyTrie test
        long startTime2 = System.nanoTime();
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        for (String word : words) {
            if (!trie.contains(word)) {
                throw new RuntimeException("Error");
            }
        }
        long endTime2 = System.nanoTime();
        double time2 = (endTime2 - startTime2) / 1_000_000_000.0;
        System.out.println("Total different words: " + trie.getSize());
        System.out.println("MyTrie: " + time2 + " s");
    }
}
