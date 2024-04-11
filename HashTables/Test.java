package HashTables;

import AVLTrees.AVLTree;
import RedBlackTree.RBTree;
import SetAndMap.BSTMap;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("PrideAndPrejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(String word: words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");


            // Test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for(String word: words)
                rbt.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");


            // Test HashTable
            startTime = System.nanoTime();

            HashTable<String, Integer> ht = new HashTable<>();
            for (String word : words) {
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }

            for(String word: words)
                ht.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
        }

        System.out.println();
    }

    private class FileOperation {

        // read file and return all words in the file
        public static boolean readFile(String filename, ArrayList<String> words){

            if (filename == null || words == null){
                System.out.println("filename is null or words is null");
                return false;
            }

            // 文件读取
            Scanner scanner;

            try {
                File file = new File(filename);
                if(file.exists()){
                    FileInputStream fis = new FileInputStream(file);
                    scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                    scanner.useLocale(Locale.ENGLISH);
                }
                else
                    return false;
            }
            catch(IOException ioe){
                System.out.println("Cannot open " + filename);
                return false;
            }

            // simple parser
            // read the file word by word
            // remove all punctuations
            if (scanner.hasNextLine()) {

                String contents = scanner.useDelimiter("\\A").next();

                int start = firstCharacterIndex(contents, 0);
                for (int i = start + 1; i <= contents.length(); )
                    if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                        String word = contents.substring(start, i).toLowerCase();
                        words.add(word);
                        start = firstCharacterIndex(contents, i);
                        i = start + 1;
                    } else
                        i++;
            }

            return true;
        }

        // find the first character in a word
        private static int firstCharacterIndex(String s, int start){

            for( int i = start ; i < s.length() ; i ++ )
                if( Character.isLetter(s.charAt(i)) )
                    return i;
            return s.length();
        }
    }

}
