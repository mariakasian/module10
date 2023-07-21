package org.example.task1;

import java.io.*;
import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "files/file1.txt";
        printValidNumber(fileName);

    }

    public static void printValidNumber(String fileName) throws FileNotFoundException {
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);
            Scanner s = new Scanner(br);

            while (s.hasNextLine()) {
                String str = s.nextLine();
                if (isValidNumber(str)) {
                    System.out.println(str);
                }
            }
            s.close();
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public static boolean isValidNumber(String number) {
        int digitsCount = 0;
        int spaceCount = 0;
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                digitsCount++;
            } else if (c == '(' || c == ')' || c == '-') {
                continue;
            } else if (c == ' ') {
                spaceCount++;
            } else {
                return false;
            }
        }
        if ((digitsCount == 10 && spaceCount == 1 && number.length() == 14) ||
                (digitsCount == 10 && spaceCount == 0 && number.length() == 12)) {
            return true;
        } else {
            return false;
        }
    }
}
