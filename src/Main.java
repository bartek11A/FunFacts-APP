import java.math.BigDecimal;
import java.math.RoundingMode;
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
        System.out.println("2. Narcissistic (Armstrong) Numbers");
        System.out.println("3. Harshad (Niven) Numbers");
        System.out.println("4. π Infinite digits generaror (Chudnovsky Algorithm)");
//        Algorithm for e adapted from https://en.wikipedia.org/wiki/E_(mathematical_constant)
        System.out.println("5. e (Euler's) number generator");
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
//                Users should choose between typing their own numbers and checking if they are Narcissistic ones or see the list in their range

//                Declaration
                int number;
                int buff;
                byte power;
                int sum;
                System.out.println("=-=-= Narcissistic Number Menu =-=-=");
                System.out.println("1. Check if your number is a Narcissistic");
                System.out.println("2. See the list of Narcissistic Numbers up to your limit");
                System.out.print("Choice: ");
                byte narcissisticChoice = scanner.nextByte();
                switch (narcissisticChoice) {
                    case 1:
                        System.out.print("Enter the number: ");
                        number = Math.abs(scanner.nextInt());
                        buff = number;

//                Calculate the number of digits
                        power = 0;
                        do {
                            power++;
                        } while ((buff /= 10) != 0);

//                Calculate the sum of the digits where each is raised to the power var
                        buff = number;
                        sum = 0;
                        do {
                            sum += Math.powExact((buff % 10), power);
                        } while ((buff /= 10) != 0);

//                Output the message
                        String verdict = (sum == number) ? " " : " not ";
                        System.out.println("The number " + number + " is" + verdict + "a Narcissistic (Armstrong) Number");
                        break;
                    case 2:
//                        Get the limit from the user
                        System.out.print("Enter the limit: ");
                        int limit = scanner.nextInt();
                        int total = 0;

//                        Loop up to the limit
                        for (number = 0; number <= limit; number++) {
//                            Calculate the number of digits
                            buff = number;
                            power = 0;
                            do {
                                power++;
                            } while ((buff /= 10) != 0);

//                Calculate the sum of the digits where each is raised to the power var
                            buff = number;
                            sum = 0;
                            do {
                                sum += Math.powExact((buff % 10), power);
                            } while ((buff /= 10) != 0);

//                    If the current number is an Armstrong number output it to the user while counting it
                            if (sum == number) {
                                System.out.println(number);
                                total++;
                            }
                        }
//                        Output the total number of Narcissistic numbers
                        System.out.println("Total: " + total + " (Narcissitic numbers)");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 3:
                System.out.println("A Harshad number (also called a Niven number) is an integer that is divisible by the sum of its digits.");

//                Get the input from the user
                System.out.print("Number: ");
                int harshadNumber = Math.abs(scanner.nextInt());

                int harshadBuff = harshadNumber;
                int harshadSum = 0;

//                Calculate the sum of digits
                do {
                    harshadSum += harshadBuff % 10;
                } while ((harshadBuff /= 10) != 0);

                String hverdict = (harshadNumber % harshadSum == 0) ? " " : " not ";
                System.out.println("The number " + harshadNumber + " is" + hverdict + "a Harshad (Niven) Number");
                break;
            case 4:
                System.out.println("In construction!");
                break;
            case 5:
                int decimalPlaces;

                do {
                    System.out.print("Decimal places (from 1 to 100): ");
                    decimalPlaces = scanner.nextInt();
                } while (decimalPlaces <= 0 || decimalPlaces > 100);

                System.out.println("=-=-=- Euler's number (mathematical constant) -=-=-=");
                BigDecimal e = BigDecimal.TWO;
                BigDecimal factorial = BigDecimal.ONE;

//                Loop that calculates e
                for (int n = 2; n < 100; n++) {
                    factorial = factorial.multiply(BigDecimal.valueOf(n));
                    e = e.add(BigDecimal.ONE.divide(factorial, 1000, RoundingMode.HALF_UP));
                }

//                Round e to the number of decimalPlaces entered by the user and output it
                e = e.divide(BigDecimal.ONE, decimalPlaces, RoundingMode.HALF_UP);
                System.out.println("e = " + e + "...");
                break;
            default:
                System.out.println("Invalid menu choice!");
        }
    }
}
