public class Main {
    static void main(String[] args) {

//        Fix year (done)
//        Fix the connection between months and days (done)
//        Format days and months (add 0 to the ones with a single digit
//        Declaration of the variable used for the loop with days
        byte daysMax;

//        Year is set to <= 52 instead of <= 126 because only the years up to "26" can form Pythagorean dates
        System.out.println("DD/MM/YYYY");
        for (int year = 1; year <= 52; year++) {

            for (byte month = 1; month <= 12; month++) {
//                Initialize the upper boundary for the number of days
                daysMax = (byte) switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12 -> 31;
//                    Ternary operator to account for leap years
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

    }
}
