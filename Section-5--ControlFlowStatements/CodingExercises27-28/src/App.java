import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /*inputThenPrintSumAndAverage();*/
        System.out.println(""+getBucketCount(3.4, 2.1, 1.5, 2));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1;
        } else {
            double area = width * height;
            double coverage = area/ areaPerBucket;
            double buckets = Math.ceil(coverage);
            System.out.println("buckets = " + buckets);
            return (int) buckets - extraBuckets;
        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0){
            return -1;
        } else {
            double area = width * height;
            double buckets = Math.ceil(area/areaPerBucket);
            return (int) buckets;
        }
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0){
            return -1;
        } else {
            double buckets = Math.ceil(area/areaPerBucket);
            return (int) buckets;
        }
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner keyboard = new Scanner(System.in);
        boolean hasNextInt = false;
        int number = 0;
        int counter = 0;
        do {
            hasNextInt = keyboard.hasNextInt();
            if (hasNextInt) {
                number += keyboard.nextInt();
                counter++;
            }
        } while (hasNextInt);
        if (counter > 0) {
            long average = Math.round((double) number / counter);
            System.out.println("SUM = " + number + " AVG = " + average);
        } else {
            System.out.println("SUM = 0 AVG = 0");
        }
        keyboard.close();
    }
}
