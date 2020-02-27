package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {

        File file = new File("wordlist.txt");
        MySet set;
        try (Scanner words = new Scanner(file)) {
            set = new MySet();

            while (words.hasNextLine()) {
                set.add(words.nextLine());
            }
        }

        if (set.contains("Arcadi")) {
            System.out.println("Found Arcadi");
        }

        if (!set.contains("Fleepsoodl")) {
            System.out.println("Fleepsoodl Doesn't Exist");
        }

    }
}

