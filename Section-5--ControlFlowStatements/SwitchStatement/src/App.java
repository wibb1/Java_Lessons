public class App {
    public static void main(String[] args) {
        ifStatement(3);
        switchStatement(1);
        swtichCharChallenge('Z');
        switchMonth("January");
        printDayOfTheWeek(0);
        printNumberInWord(1);
        printAnswer((isLeapYear(10000)) ? "true" : "false");
        printAnswer("" + getDaysInMonth(12, 10000));
    }

    public static void ifStatement(int value) {
        if (value == 1) {
            printAnswer("Value was 1");
        } else if (value == 2) {
            printAnswer("Value was 2");
        } else {
            printAnswer("Value was not 1 or 2");
        }
    }

    public static void switchStatement(int switchValue) {
        switch (switchValue) {
            case 1:
                printAnswer("Value was 1");
                break;
            case 2:
                printAnswer("Value was 2");
                break;
            case 3:
            case 4:
            case 5:
                printAnswer("Value was 3, 4 or 5");
                break;
            default:
                printAnswer("Value was not 1 or 2");
                break;
        }

    }

    public static void swtichCharChallenge(char switchChar) {
        switch (switchChar) {
            case 'A':
            case 'E':
                printAnswer("It's an " + switchChar);
                break;
            case 'B':
            case 'C':
            case 'D':
                printAnswer("It's a " + switchChar);
                break;
            default:
                printAnswer("It' not an A, B, C, D, or E");
                break;
        }

    }

    public static void switchMonth(String month) {
        String answer = "Please enter the entire month name";
        month = month.toLowerCase();
        switch (month) {
            case "january":
            case "february":
            case "march":
            case "april":
            case "may":
            case "june":
            case "july":
            case "august":
            case "september":
            case "october":
            case "november":
            case "december":
                answer = "The month is " + month.substring(0, 1).toUpperCase() + month.substring(1);
                break;
            default:
                break;
        }
        printAnswer(answer);
    }

    public static void printDayOfTheWeek(int day) {
        String answer = "Invalid day";
        switch (day) {
            case 0:
                answer = "Your day is Sunday";
                break;
            case 1:
                answer = "Your day is Monday";
                break;
            case 2:
                answer = "Your day is Tuesday";
                break;
            case 3:
                answer = "Your day is Wednesday";
                break;
            case 4:
                answer = "Your day is Thursday";
                break;
            case 5:
                answer = "Your day is Friday";
                break;
            case 6:
                answer = "Your day is Saturday";
                break;
            default:
                break;
        }
        printAnswer(answer);
    }

    public static void printDayOfTheWeek2(int value) {
        String answer = "Your day number was incorrect (0-6) are acceptable";
        if (value == 0) {
            answer = "Your day is Sunday";
        } else if (value == 1) {
            answer = "Your day is Monday";
        } else if (value == 2) {
            answer = "Your day is Tuesday";
        } else if (value == 3) {
            answer = "Your day is Wednesday";
        } else if (value == 4) {
            answer = "Your day is Thursday";
        } else if (value == 5) {
            answer = "Your day is Friday";
        } else if (value == 6) {
            answer = "Your day is Saturday";
        }

        printAnswer(answer);
    }

    public static void printNumberInWord(int number) {
        String answer = "OTHER";
        switch (number) {
            case 0:
                answer = "ZERO";
                break;
            case 1:
                answer = "ONE";
                break;
            case 2:
                answer = "TWO";
                break;
            case 3:
                answer = "THREE";
                break;
            case 4:
                answer = "FOUR";
                break;
            case 5:
                answer = "FIVE";
                break;
            case 6:
                answer = "SIX";
                break;
            case 7:
                answer = "SEVEN";
                break;
            case 8:
                answer = "EIGHT";
                break;
            case 9:
                answer = "NINE";
                break;
            default:
                break;
        }
        System.out.println(answer);
    }

    public static boolean isLeapYear(int year) {
        boolean output = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)) {
            output = true;
        }
        return output;
    }

    public static int getDaysInMonth(int month, int year) {
        int answer = -1;
        if (year >= 1 && year <= 9999) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    answer = 31;
                    break;
                case 9:
                case 4:
                case 6:
                case 11:
                    answer = 30;
                    break;
                case 2:
                    if (isLeapYear(year)) {
                        answer = 29;
                    } else {
                        answer = 28;
                    }
                    break;
                default:
                    break;
            }
        }
        return answer;
    }

    public static void printAnswer(String answer) {
        System.out.println(answer);
    }

}
