package Assesment_Week1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * This class handles conversion of a given date-time string to a specific format
 * and converts it to UTC time zone.
 */
public class DateAndTime {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date and time (dd-MM-yyyy HH:mm:ss):");
        String inputDateTime = scanner.nextLine();

        // Parse the input date-time string to a Date object
        Date parsedDate = dateFormat.parse(inputDateTime);
        String formattedDateTime = dateFormat.format(parsedDate);
        System.out.println("Formatted date-time: " + formattedDateTime);

        // Set the time zone to UTC using TimeZone class
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        dateFormat.setTimeZone(utcTimeZone);

        // Convert the formatted date-time string to UTC time zone and print the result
        Date utcDate = dateFormat.parse(formattedDateTime);
        System.out.println("Converted date-time (UTC): " + utcDate);
        scanner.close();
    }
}
