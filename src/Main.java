public class Main {
    static void main(String[] args) {

        for (int year = 1; year <= 26; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (day * day + month * month == year * year) {
                        System.out.println((year < 10) ? day + "." + month + ".200" + year : day + "." + month + ".20" + year);
                    }
                }
            }
        }

    }
}
