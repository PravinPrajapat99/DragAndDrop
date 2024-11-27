package Assesment_Week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * The FileProcessor class is used to count the frequency of repeating words
 * and remove words like (and|or|is|the) from the file, ensuring empty lines are not written to the new file.
 */
public class FileProcessor {

    public static void main(String[] args) throws IOException {
        String source = "src/main/java/Assesment_Week1/test.txt";
        String target = "src/main/java/Assesment_Week1/newfile.txt";
        File inputFile = new File(source);
        File outputFile = new File(target);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String currentLine;
        Map<String, Integer> wordFrequency = new HashMap<>();
        boolean firstLine = true;  // Track if it's the first valid line

        // Process each line from the input file
        while ((currentLine = reader.readLine()) != null) {
            // Skip empty lines
            if (currentLine.trim().isEmpty()) {
                continue;
            }
            String[] words = currentLine.split("\\s+");
            StringBuilder lineContent = new StringBuilder();  // To hold the valid words of the current line
            for (String word : words) {
                // Clean up the word: remove punctuation and convert to lowercase
                word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
                if (word.isEmpty() || word.equals("and") || word.equals("or") || word.equals("is") || word.equals("the")) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    continue;
                }
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                if (lineContent.length() > 0) {
                    lineContent.append(" ");  // Add space between words
                }
                lineContent.append(word);
            }
            if (lineContent.length() > 0) {
                if (!firstLine) {
                    writer.newLine();  // Add a newline before the next valid line
                }
                writer.write(lineContent.toString());
                firstLine = false;  // After the first valid line, set flag to false
            }
        }
        System.out.println("Duplicate words:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
            }
        }
        reader.close();
        writer.close();
    }
}
