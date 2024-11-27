package Assesment_Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The WordSearch class allows the user to search for a word in a list of words.
 * It prints the words that match the search term, or "Not present" if no matches are found.
 */
public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lst = new ArrayList<>();
        System.out.println("Enter the number of words you want to add:");
        int numWords = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter " + numWords + " words:");
        for (int i = 0; i < numWords; i++) {
            String word = sc.nextLine();
            lst.add(word);
        }
        System.out.println("Enter the search term:");
        String s = sc.nextLine();

        // Use lambda expression to filter the list and find exact matches
        // Lambda to filter the word that matches
        boolean found = lst.stream()
                .filter(word -> word.equals(s))        // Print each match
                .count() > 0;                     // Check if any match is found
        if (!found) {
            System.out.println("Not present");
        }else {
            System.out.println("word Found");
        }

        // Close the scanner to prevent resource leak
        sc.close();
    }
}
