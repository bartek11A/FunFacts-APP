public class Main {
    static void main(String[] args) {

//        Fix year (done)
//        Fix the connection between months and days
//        Declaration of the variable used for the loop with days
        byte daysMax;


        for (int year = 1; year <= 126; year++) {

            for (byte month = 1; month <= 12; month++) {
//                Initialize the upper boundary for the number of days
                daysMax = (byte) switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12 -> 31;
//                    Ternary operator to account for leap years
                    case 2 -> (year % 4 == 0) ? 29 : 28;
                    default -> 30;
                };

                for (byte day = 1; day <= daysMax; day++) {
                    if (year <= 99) {
                        if (day * day + month * month == year * year) {
                            System.out.println((year < 10) ? day + "." + month + ".190" + year : day + "." + month + ".19" + year);
                        }
                    } else if (year > 100) {
                        int yearTwenty = year - 100;
                        if (day * day + month * month == yearTwenty * yearTwenty) {
                            System.out.println((yearTwenty < 10) ? day + "." + month + ".200" + yearTwenty : day + "." + month + ".20" + yearTwenty);
                        }
                    }

                }
            }
        }

    }
}
