package Assesment_Week1;

import java.util.Scanner;

/**
 * This class contains a method to find the second largest number in an array of integers provided by the user.
 * The program allows the user to input the elements of the array and then calculates the largest and second largest numbers.
 */
public class SecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        // Initialize the largest and second largest numbers
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Find the largest number in the array
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }

        // Find the second largest number in the array
        for (int number : numbers) {
            if (number > secondLargest && number < largest) {
                secondLargest = number;
            }
        }

        System.out.println("Second largest number: " + secondLargest);
    }
}
