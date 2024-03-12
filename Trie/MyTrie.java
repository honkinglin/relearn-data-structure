package Trie;

import java.util.TreeMap;

public class MyTrie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public MyTrie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // Add a word to the trie
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // cur.next.computeIfAbsent(c, k -> new Node());
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // Check if the trie contains a word
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // Check if there is any word in the trie that starts with the given prefix
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        String filename = "Trie/PrideAndPrejudice.txt";
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
        MyTrie trie = new MyTrie();
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
