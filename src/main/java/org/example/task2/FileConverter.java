package org.example.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileConverter {
    public static void main(String[] args) throws IOException {
        String inputFile = "files/file2.txt";
        String outputFile = "files/user.json";
        List<User> userList = readFromFile(inputFile);
        writeToJsonFile(userList, outputFile);
    }
    public static List<User> readFromFile(String fileName) throws IOException {
        List<User> userList = new ArrayList<>();
        FileReader file = new FileReader(fileName);
        BufferedReader br = new BufferedReader(file);
        Scanner s = new Scanner(br);

        while (s.hasNextLine()) {
            String str = s.nextLine();
            String[] datas = str.split(" ");
            String name = datas[0];
            int age;
            if (datas[1].matches("[0-9]+")) {
                age = Integer.parseInt(datas[1]);
                userList.add(new User(name, age));
            } else {
                throw new NumberFormatException("Invalid age: " + datas[1]);
            }
        }
        s.close();
        file.close();
        return userList;
    }
    public static void writeToJsonFile(List<User> userList, String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);
        FileWriter writer = new FileWriter(fileName);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}



