package BusinessLogic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExample
{
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Add 5 days to the current date
        LocalDate futureDate = currentDate.plusDays(5);

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Format the future date
        String formattedDate = futureDate.format(formatter);

        // Print the formatted date
        System.out.println("Current date + 5 days: " + formattedDate);
    }
}
