public class App {
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
    }

    public static void getDurationString(long minutes, long seconds) {
        String answer = "Invalid Value";
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
        String answer = "Invalid Value";
        if (minutes >= 0) {
            long days = minutes / 60 / 24;
            long yrs = days / 365;
            long dys = days % 365;
            answer = minutes + " min = " + yrs + " y and " + dys + " d";
        }
        System.out.println(answer);
    }
}
