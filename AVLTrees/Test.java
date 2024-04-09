package AVLTrees;

import SetAndMap.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

        System.out.println();

        AVLSet<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVL Set: " + time3 + " s");

        System.out.println("-------------------------------------------------");

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time4 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time4 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time5 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time5 + " s");

        System.out.println();

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time6 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time6 + " s");
    }


    private static double testSet(Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    private static double testMap(Map<String, Integer> map, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words){
                if(map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    // read file and return all words in the file
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