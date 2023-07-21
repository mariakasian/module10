package org.example.task3;

import java.io.*;
import java.util.*;

public class WordCounter {

        public static void main(String[] args) throws IOException {
            String fileName = "files/words.txt";
            Map<String, Integer> map = calculateWords(fileName);
            printWords(map);
        }
        public static Map<String, Integer> calculateWords(String fileName) throws IOException {
            Map<String, Integer> map = new HashMap<>();
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);

            String str;

            while ((str = br.readLine()) != null) {
                String[] words = str.trim().split(" ");
                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
            br.close();
            return map;
        }

        public static void printWords(Map<String, Integer> map) {
            List<Map.Entry<String, Integer>> wordsList = new ArrayList<>(map.entrySet());
            wordsList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            for (Map.Entry<String, Integer> entry : wordsList) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
}
