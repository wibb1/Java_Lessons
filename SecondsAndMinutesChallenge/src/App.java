public class App {
    public static void main(String[] args) {
        getDurationString(65, 45);
        getDurationString(1000000000, 50);
        getDurationString(85, 59);
        getDurationString(3600, 50);
        getDurationString(61,0);
        getDurationString(87600);
        getDurationString(55000);
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
    
}
