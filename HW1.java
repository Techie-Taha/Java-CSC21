public class JDFConverter {
    public static void main(String[] args) {
        String date = "2000-03-01";
        String jdf = calculateJDF(date);
        System.out.printf("The Julian date for %s is %s.%n", date, jdf); 
    }

    public static String calculateJDF(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] daysInMonth = { 
            31, 28, 31, 30, 31, 30, 
            31, 31, 30, 31, 30, 31 
        };


        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) { 
            daysInMonth[1] = 29; 
        }

        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) { 
            dayOfYear += daysInMonth[i]; 
        }

        int twoDigitYear = year % 100;

        return String.format("%02d%03d", twoDigitYear, dayOfYear); 
        }
}


