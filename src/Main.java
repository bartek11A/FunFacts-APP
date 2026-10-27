import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Declaration of the variable used for the loop with days
        byte daysMax;

//        Menu
        System.out.println("=-=-= WELCOME TO THE FunFacts APP - YOUR PLACE FOR MATH-RELATED FUN FACTS =-=-=");
        System.out.println("\n=-=-= MENU =-=-=");
        System.out.println("1. Pythagorean Dates");
        System.out.println("2. Narcissistic (Armstrong) Number Scanner");
        System.out.print("Choose an option: ");
        byte menuChoice = scanner.nextByte();

        switch (menuChoice) {
            case 1:
//              Year is set to <= 52 instead of <= 126 because only the years up to "26" can form Pythagorean dates
                System.out.println("\nPythagorean Dates");
                System.out.println("DD/MM/YYYY");
//                To add: last and the nearest!
                for (int year = 1; year <= 52; year++) {

                    for (byte month = 1; month <= 12; month++) {
//                      Initialize the upper boundary for the number of days
                        daysMax = (byte) switch (month) {
                            case 1, 3, 5, 7, 8, 10, 12 -> 31;
//                          Ternary operator to account for leap years
                            case 2 -> (year % 4 == 0) ? 29 : 28;
                            default -> 30;
                        };

                        for (byte day = 1; day <= daysMax; day++) {
                            if (year <= 26) {
                                if (day * day + month * month == year * year) {
                                    System.out.print((day < 10) ? "0" + day + "." : day + ".");
                                    System.out.print((month < 10) ? "0" + month + "." : month + ".");
                                    System.out.println((year < 10) ? "190" + year : "19" + year);
                                }
                            } else {
                                int yearTwenty = year - 26;
                                if (day * day + month * month == yearTwenty * yearTwenty) {
                                    System.out.print((day < 10) ? "0" + day + "." : day + ".");
                                    System.out.print((month < 10) ? "0" + month + "." : month + ".");
                                    System.out.println((yearTwenty < 10) ? "200" + yearTwenty : "20" + yearTwenty);
                                }
                            }

                        }
                    }
                }
                break;
            case 2:
//                A Narcissistic Number (also called an Armstrong Number) is a number that equals the sum of its own digits, where each digit is raised to the power of the total number of digits.
//                Users should choose between typing their own numbers and checking if they are narcistic ones or see the list in their range
//                First typing their own numbers
                System.out.print("Enter a number that you want to check (negative numbers will be converted to the positive ones): ");
                int number = Math.abs(scanner.nextInt());
                int buff = number;

//                Calculate the number of digits
                byte power = 0;
                do {
                    power++;
                } while ((buff /= 10) != 0);

//                Calculate the sum of the digits where each is raised to the power var
                buff = number;
                int sum = 0;
                do {
                    sum += Math.powExact((buff % 10), power);
                } while ((buff /= 10) != 0);

//                Output the message
                String verdict = (sum == number) ? " " : " not ";
                System.out.println("The number " + number + " is" + verdict + "a Narcissistic (Armstrong) Number");
                break;
            default:
                System.out.println("Invalid menu choice!");
        }
    }
}
