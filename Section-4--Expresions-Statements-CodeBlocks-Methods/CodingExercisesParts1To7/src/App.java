public class App {
    public static void main(String[] args) {
        //SOLUTION 7
        System.out.println(hasTeen(9, 99, 19));
        System.out.println(hasTeen(23, 15, 42));
        System.out.println(hasTeen(22, 23, 34));

    }

        public static boolean hasTeen(int age1, int age2, int age3) {
            boolean answer = false;
            if (isTeen(age1) || isTeen(age2) || isTeen(age3)) {
                answer = true;
            }
            return answer;
        }

        public static boolean isTeen(int age) {
            boolean answer = false;
            if (age >= 13 && age <= 19) {
                answer = true;
            }
            return answer;
        }


        /*
        //SOLUTION 6
        System.out.println(hasEqualSum(1, 1, 1)); //false
        System.out.println(hasEqualSum(1, 1, 2)); //true
        System.out.println(hasEqualSum(1, -1, 0)); //true
    }
    
    public static boolean hasEqualSum(int n1, int n2, int n3) {
        boolean answer = false;
        if (n1 + n2 == n3) {
            answer = true;
        }
        return answer;
    }
        
        
        /* SOLUTION 5
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175)); //true
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176)); //false
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0)); //true
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123)); //false
    }

    public static boolean areEqualByThreeDecimalPlaces(double d1, double d2) {
        boolean answer = false;
        if ((int) (d1 * 1000) == (int) (d2 * 1000)) {
            answer = true;
        }
        return answer;
    }
    /*
     * / SOLUTIOIN 4 System.out.println("not leap years");
     * System.out.println(String.valueOf(isLeapYear(1700)));
     * System.out.println(String.valueOf(isLeapYear(1800)));
     * System.out.println(String.valueOf(isLeapYear(1900)));
     * System.out.println(String.valueOf(isLeapYear(2100)));
     * System.out.println(String.valueOf(isLeapYear(2200)));
     * System.out.println(String.valueOf(isLeapYear(2300)));
     * System.out.println(String.valueOf(isLeapYear(2500)));
     * System.out.println(String.valueOf(isLeapYear(2600)));
     * 
     * System.out.println("leap years");
     * System.out.println(String.valueOf(isLeapYear(1600)));
     * System.out.println(String.valueOf(isLeapYear(2000)));
     * System.out.println(String.valueOf(isLeapYear(2400)));
     * System.out.println(String.valueOf(isLeapYear(1924)));
     * 
     * System.out.println("input output");
     * System.out.println(String.valueOf(isLeapYear(-1600)));
     * System.out.println(String.valueOf(isLeapYear(1600)));
     * System.out.println(String.valueOf(isLeapYear(2017)));
     * System.out.println(String.valueOf(isLeapYear(2000)));
     * 
     * }
     * 
     * public static boolean isLeapYear(int year) { boolean value = false; if (year
     * >= 1 && year <= 9999 && year % 4 == 0) { if (year % 100 == 0) { if (year %
     * 400 == 0) { value = true; } } else { value = true; } } return value; }
     * 
     * /* // SOLUTION 3 System.out.println(shouldWakeUp(true, 1)); // true
     * System.out.println(shouldWakeUp(false, 2)); // false -> dog is not barking
     * System.out.println(shouldWakeUp(true, 8)); // false -> before 8
     * System.out.println(shouldWakeUp(true, -1)); // false -> param 0 - 23 }
     * 
     * public static boolean shouldWakeUp(boolean barking, int hourOfDay) { boolean
     * wakeUp = false; if (barking && (hourOfDay >= 0 && hourOfDay <= 23) &&
     * (hourOfDay < 8 || hourOfDay > 22)) { wakeUp = true; } return wakeUp; } /* //
     * SOLUTION 2 printMegaBytesAndKiloBytes(2500); //2500 KB = 2 MB and 452 KB
     * printMegaBytesAndKiloBytes(-1024); //Invalid Value
     * printMegaBytesAndKiloBytes(5000); //5000 KB = 4 MB and 904 KB }
     * 
     * // 1 MB = 1024 KB public static void printMegaBytesAndKiloBytes(int
     * kiloBytes) { if (kiloBytes < 0) { System.out.println("Invalid Value"); } else
     * { System.out.print(kiloBytes + " KB = " + kiloBytes / 1024 + " MB and " +
     * kiloBytes % 1024 + " KB\n"); }
     * 
     * SOLUTION 1 printConversion(1.5); // should print the following text (into the
     * console - System.out): 1.5 km/h = 1 // mi/h printConversion(10.25); // should
     * print the following text (into the console - System.out): 10.25 km/h = // 6
     * mi/h printConversion(-5.6); // should print the following text (into the
     * console - System.out): Invalid // Value printConversion(25.42); // should
     * print the following text (into the console - System.out): 25.42 km/h = // 16
     * mi/h printConversion(75.114); // should print the following text (into the
     * console - System.out): 75.114 km/h // = 47 mi/h }
     * 
     * public static long toMilesPerHour(double kilometersPerHour) { long
     * toMilesPerHour = Math.round(kilometersPerHour / 1.609); if (toMilesPerHour <
     * 0) { return -1; } return toMilesPerHour; }
     * 
     * public static void printConversion(double kilometersPerHour) { if
     * (kilometersPerHour < 0) { System.out.println("Invalid Value"); } else {
     * System.out.println(kilometersPerHour + " km/h = " +
     * toMilesPerHour(kilometersPerHour) + " mi/h"); } }
     * 
     */

}
