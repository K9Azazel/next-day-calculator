public class NextDayCalculator {

    public static final String CONCATENATION = "/";
    public static final String FIRSTOFMONTH = "1";

    public static String getNextDay(int dayTest, int monthTest, int yearTest) {
        String result;
        int lastOfMonth = getLastOfMonth(monthTest, yearTest);
        if (dayTest == lastOfMonth && !checkLastOfYear(dayTest,monthTest)) {
            result = FIRSTOFMONTH + CONCATENATION + (++monthTest) + CONCATENATION + yearTest;
            return result;
        } else if(checkLastOfYear(dayTest,monthTest))
            return FIRSTOFMONTH + CONCATENATION + FIRSTOFMONTH + CONCATENATION + ++yearTest;

        else result = ++dayTest + CONCATENATION + monthTest + CONCATENATION + yearTest;
        return result;
        }

    private static int getLastOfMonth(int monthTest, int yearTest) {
        int lastOfMonth;
        switch (monthTest) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            case 2: {
                if (checkPrime(yearTest))
                    return 29;
                else return 28;
            }
            default:
                lastOfMonth = 30;

        }
        return lastOfMonth;
    }

    private static boolean checkPrime(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static boolean checkLastOfYear(int dayTest, int monthTest) {
        return dayTest == 31 && monthTest == 12;
    }
}