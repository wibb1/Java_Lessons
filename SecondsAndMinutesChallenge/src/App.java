public class App {

    static final String INVALID_VALUE = "Invalid Value";

    public static void main(String[] args) {
        System.out.println("SecondsAndMinutesChallenge");
        getDurationString(65, 45);
        getDurationString(1000000000, 50);
        getDurationString(85, 59);
        getDurationString(3600, 50);
        getDurationString(61, 0);
        getDurationString(87600);
        getDurationString(55000);

        System.out.println("Area Calculator Challenge");
        System.out.println(area(5.0));
        System.out.println(area(-1));
        System.out.println(area(5.0, 4.0));
        System.out.println(area(-1.0, 4.0));
        System.out.println(area(-1.0, 5.0));

        System.out.println("Minutes to years and days calculator");
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);

        System.out.println("Equality Printer");
        printEqual(1, 1, 1); // "All numbers are equal"
        printEqual(1, 1, 2); // "Neither all are equal or different"
        printEqual(-1, -1, -1); // "Invalid Value"
        printEqual(1, 2, 3); // "All the numbers are different"
    }

    public static void getDurationString(long minutes, long seconds) {
        String answer = INVALID_VALUE;
        if (minutes >= 0 && seconds >= 0 && seconds <= 59) {
            long hours = minutes / 60;
            minutes %= 60;
            answer = convertString(hours) + "h " + convertString(minutes) + "m " + convertString(seconds) + "s";
        }
        System.out.println(answer);
    }

    public static void getDurationString(long seconds) {
        if (seconds >= 0) {
            long minutes = seconds / 60;
            seconds %= 60;
            getDurationString(minutes, seconds);
        }
    }

    public static String convertString(long value) {
        String string = "";
        if (value < 10) {
            string = "0" + value;
        } else {
            string += value;
        }
        return string;
    }

    // Area Calculator Challenge
    public static double area(double radius) {
        double area = -1;
        if (radius >= 0) {
            area = Math.PI * radius * radius;
        }
        return area;
    }

    public static double area(double x, double y) {
        double area = -1;
        if (x >= 0 && y >= 0) {
            area = x * y;
        }
        return area;
    }

    // Minutes to years and days calculator
    public static void printYearsAndDays(long minutes) {
        String answer = INVALID_VALUE;
        if (minutes >= 0) {
            long days = minutes / 60 / 24;
            long yrs = days / 365;
            long dys = days % 365;
            answer = minutes + " min = " + yrs + " y and " + dys + " d";
        }
        System.out.println(answer);
    }

    // Equality Printer
    public static void printEqual(int int1, int int2, int int3) {
        String answer = "";
        if (int1 < 0 || int2 < 0 || int3 < 0){
            answer = INVALID_VALUE;
        } else if (int1 == int2 && int2 == int3) {
            answer = "All numbers are equal";
        } else if (int1 == int2 || int1 == int3 || int2 == int3) {
            answer = "Neither all are equal or different";
        } else {
            answer = "All numbers are different";
        }
        System.out.println(answer);
    }

    // Playing Cat
    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean answer = false;
        if ((temperature >= 25 && temperature <= 35) || (summer && temperature >= 25 && temperature <= 45)) {
            answer = true;
        } 
        return answer;
    }
}
