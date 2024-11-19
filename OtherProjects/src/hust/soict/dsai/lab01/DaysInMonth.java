package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        String[] months31 = {"January", "Jan.", "Jan", "1", "March", "Mar.", "Mar", "3", "May", "5", "July", "Jul.", "Jul", "7", "August", "Aug.", "Aug", "8", "October", "Oct.", "Oct", "10", "December", "Dec.", "Dec", "12"};
        String[] months30 = {"April", "Apr.", "Apr", "4", "June", "Jun.", "Jun", "6", "September", "Sept.", "Sep", "9", "November", "Nov.", "Nov", "11"};
        String[] months28 = {"February", "Feb.", "Feb", "2"};
        Scanner sc = new Scanner(System.in);
        long year = 0;
        String month;
        boolean validYear, validMonth;

        do {
            System.out.println("Enter a year:");
            if (sc.hasNextLong()) {
                year = sc.nextLong();
                validYear = year >= 0;
            } 
            else {
                validYear = false;
            }
            sc.nextLine();
            if (!validYear) {
                System.out.println("Invalid input. Please enter a non-negative integer for the year.");
            }
        } while (!validYear);

        do {
            System.out.println("Enter a month:");
            month = sc.nextLine();
            validMonth = false;
            for (String m : months31) {
                if (month.equalsIgnoreCase(m)) {
                    System.out.println("The month has 31 days.");
                    validMonth = true;
                    break;
                }
            }
            if (!validMonth) {
                for (String m : months30) {
                    if (month.equalsIgnoreCase(m)) {
                        System.out.println("The month has 30 days.");
                        validMonth = true;
                        break;
                    }
                }
            }
            if (!validMonth) {
                for (String m : months28) {
                    if (month.equalsIgnoreCase(m)) {
                        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                            System.out.println("The month has 29 days.");
                        } else {
                            System.out.println("The month has 28 days.");
                        }
                        validMonth = true;
                        break;
                    }
                }
            }
            if (!validMonth) {
                System.out.println("Invalid input. Please enter a valid month.");
            }
        } while (!validMonth);
    }
}