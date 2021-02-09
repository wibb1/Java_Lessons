public class App {
    public static void main(String[] args) {
        /*
         * printAnswer("while loop"); int count = 1; while (count >= 6) {
         * printAnswer("count value is " + count); count++; }
         * 
         * printAnswer("for loop"); for (int i = 1; i <= 6; i++) {
         * printAnswer("count value is " + i); }
         * 
         * printAnswer("while loop 2"); count = 1; while (true) { if (count >= 6) break;
         * printAnswer("Count value is " + count); count++; }
         * 
         * printAnswer("do loop"); count = 1; do { printAnswer("Count value is " +
         * count); count++; } while (count <= 6);
         * 
         * printAnswer("***While loop challenge***");
         * 
         * int number = 4; int finishNumber = 500; count = 0; while (number <=
         * finishNumber && count < 5) { number++; if (isEvenNumber(number)) {
         * printAnswer("Even Number " + number); count++; } }
         * printAnswer("Total numbers found = " + count);
         * 
         * printAnswer(" The sum of -10 is " + sumDigits(-10) +
         * " and should return -1"); printAnswer(" The sum of 9 is " + sumDigits(9) +
         * " and should return -1"); printAnswer(" The sum of 10 is " + sumDigits(10) +
         * " and should return 1"); printAnswer(" The sum of 15 is " + sumDigits(15) +
         * " and should return 6"); printAnswer(" The sum of 125 is " + sumDigits(125) +
         * " and should return 8"); printAnswer(" The sum of 50000 is " +
         * sumDigits(50000) + " and should return 5"); printAnswer(" The sum of 16 is "
         * + sumDigits(16) + " and should return 7"); printAnswer(" The sum of 34 is " +
         * sumDigits(34) + " and should return 7"); printAnswer(" The sum of 92158 is "
         * + sumDigits(92158) + " and should return 25");
         * 
         * printAnswer("number is a palindrome"); int test = 121;
         * printAnswer(isPalindrome(test) ? (test + " is a palindrome") : (test +
         * " is NOT a palidrome")); test = 23; printAnswer(isPalindrome(test) ? (test +
         * " is a palindrome") : (test + " is NOT a palidrome")); test = 23366332;
         * printAnswer(isPalindrome(test) ? (test + " is a palindrome") : (test +
         * " is NOT a palidrome")); test = -222; printAnswer(isPalindrome(test) ? (test
         * + " is a palindrome") : (test + " is NOT a palidrome"));
         * 
         * printAnswer("first and last digit sum coding exercise"); int sumDigits = 252;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = 257;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = 0;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = 5;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = -10;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = 101;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = -89898989;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits)); sumDigits = -58436584;
         * printAnswer("the sum of the first and last digits of " + sumDigits + " is " +
         * sumFirstAndLastDigit(sumDigits));
         * 
         * printAnswer("Even digit sum coding exercise"); sumDigits = 123456789;
         * printAnswer("Sum of the even digits of " + sumDigits + " is equal to " +
         * getEvenDigitSum(sumDigits)); sumDigits = 987654321;
         * printAnswer("Sum of the even digits of " + sumDigits + " is equal to " +
         * getEvenDigitSum(sumDigits)); sumDigits = 125896547;
         * printAnswer("Sum of the even digits of " + sumDigits + " is equal to " +
         * getEvenDigitSum(sumDigits)); sumDigits = 135971359;
         * printAnswer("Sum of the even digits of " + sumDigits + " is equal to " +
         * getEvenDigitSum(sumDigits)); sumDigits = 246810126;
         * printAnswer("Sum of the even digits of " + sumDigits + " is equal to " +
         * getEvenDigitSum(sumDigits)); sumDigits = 222222222;
         * printAnswer("Sum of the even digits of " + sumDigits + " is equal to " +
         * getEvenDigitSum(sumDigits));
         * 
         * printAnswer("shared digit sum coding exercise"); int sumDigit1 = 2; int
         * sumDigit2 = 20; printAnswer(hasSharedDigit(sumDigit1, sumDigit2) ? sumDigit1
         * + " and " + sumDigit2 + " share digits" : sumDigit1 + " and " + sumDigit2 +
         * " DON'T share digits"); sumDigit1 = 100; sumDigit2 = 55;
         * printAnswer(hasSharedDigit(sumDigit1, sumDigit2) ? sumDigit1 + " and " +
         * sumDigit2 + " share digits" : sumDigit1 + " and " + sumDigit2 +
         * " DON'T share digits"); sumDigit1 = 52; sumDigit2 = 25;
         * printAnswer(hasSharedDigit(sumDigit1, sumDigit2) ? sumDigit1 + " and " +
         * sumDigit2 + " share digits" : sumDigit1 + " and " + sumDigit2 +
         * " DON'T share digits"); sumDigit1 = 25; sumDigit2 = 36;
         * printAnswer(hasSharedDigit(sumDigit1, sumDigit2) ? sumDigit1 + " and " +
         * sumDigit2 + " share digits" : sumDigit1 + " and " + sumDigit2 +
         * " DON'T share digits"); sumDigit1 = 98; sumDigit2 = 25;
         * printAnswer(hasSharedDigit(sumDigit1, sumDigit2) ? sumDigit1 + " and " +
         * sumDigit2 + " share digits" : sumDigit1 + " and " + sumDigit2 +
         * " DON'T share digits"); sumDigit1 = 12; sumDigit2 = 13;
         * printAnswer(hasSharedDigit(sumDigit1, sumDigit2) ? sumDigit1 + " and " +
         * sumDigit2 + " share digits" : sumDigit1 + " and " + sumDigit2 +
         * " DON'T share digits");
         * 
         * printAnswer("isValid"); printAnswer(isValid(9)? "The answer is true" :
         * "the answer is false"); printAnswer(isValid(10)? "The answer is true" :
         * "the answer is false");
         * 
         * printAnswer("hasSameLastDigit"); printAnswer(hasSameLastDigit(41, 22, 71) ?
         * "The answer is true" : "the answer is false");
         * printAnswer(hasSameLastDigit(23, 32, 42) ? "The answer is true" :
         * "the answer is false"); printAnswer(hasSameLastDigit(9, 99, 999) ?
         * "The answer is true" : "the answer is false");
         * 
         * printAnswer("The greatest divisor is " + getGreatestCommonDivisor(25, 15));
         * printAnswer("The greatest divisor is " + getGreatestCommonDivisor(12, 30));
         * printAnswer("The greatest divisor is " + getGreatestCommonDivisor(9, 18));
         * printAnswer("The greatest divisor is " + getGreatestCommonDivisor(81, 153));
         * printAnswer("The greatest divisor is " + getGreatestCommonDivisor(12, 24));
         *
         * printFactors(6); printFactors(32); printFactors(10); printFactors(-1);
         * 
         * printAnswer(isPerfectNumber(6) ? "True" : "False");
         * printAnswer(isPerfectNumber(28) ? "True" : "False");
         * printAnswer(isPerfectNumber(5) ? "True" : "False");
         * printAnswer(isPerfectNumber(-1) ? "True" : "False");
         * printAnswer(isPerfectNumber(64) ? "True" : "False");
         * printAnswer(isPerfectNumber(18) ? "True" : "False");
         * 
         * 
         **/
        // int testNumber = 0; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 123;
        // printAnswer(testNumber + " has " + getDigitCount(testNumber) + " digits");
        // printAnswer("The reverse of " + testNumber + " is " + reverse(testNumber));
        // numberToWords(testNumber);

        // testNumber = -12; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 5200; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 1212; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 1234; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 100; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 1010; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = 1000; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // testNumber = -2521; printAnswer(testNumber + " has " +
        // getDigitCount(testNumber) + " digits"); printAnswer("The reverse of " +
        // testNumber + " is " + reverse(testNumber)); numberToWords(testNumber);

        // }

        // public static void numberToWords(int number){
        // if(number<0) System.out.print("Invalid Value");
        // int count = getDigitCount(number);
        // number = reverse(number);
        // for(int i=0; i<count; i++){
        // int digit = number%10;
        // switch(digit){
        // case 0:
        // System.out.print("Zero "); break;
        // case 1:
        // System.out.print("One "); break;
        // case 2:
        // System.out.print("Two "); break;
        // case 3:
        // System.out.print("Three "); break;
        // case 4:
        // System.out.print("Four "); break;
        // case 5:
        // System.out.print("Five "); break;
        // case 6:
        // System.out.print("Six "); break;
        // case 7:
        // System.out.print("Seven "); break;
        // case 8:
        // System.out.print("Eight "); break;
        // case 9:
        // System.out.print("Nine "); break;
        // default: break;
        // }
        // number /= 10;
        // }
        // }

        // public static int reverse(int number) {
        // int reverse = 0;
        // int digit = 0;
        // while(number!=0) {
        // digit = number%10;
        // reverse = (reverse*10) + digit;
        // number /= 10;
        // }
        // return reverse;
        // }

        // public static int getDigitCount(int number){
        // if (number<0) return -1;
        // int count = 0;
        // do{
        // count++;
        // number /= 10;
        // }while (number>0);
        // return count;
        // }
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1)
            return false;
        int sum = 1;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                sum += number / i;
            }
        }
        return sum == number;
    }

    public static void printFactors(int number) {
        if (number < 1)
            System.out.println("Invalid Value");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                System.out.println(i);
        }
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10)
            return -1;
        int low = 0;
        int highDivisor = 0;
        if (first < second) {
            low = first;
        } else {
            low = second;
        }
        for (int i = 1; i <= low; i++) {
            if (first % i == 0 && second % i == 0)
                highDivisor = i;
        }
        return highDivisor;
    }

    public static boolean hasSameLastDigit(int n1, int n2, int n3) {
        if (!isValid(n1) || !isValid(n2) || !isValid(n3))
            return false;
        return (n1 % 10 == n2 % 10 || n1 % 10 == n3 % 10 || n2 % 10 == n3 % 10);
    }

    public static boolean isValid(int number) {
        return (number >= 10 && number <= 1000);
    }

    public static boolean hasSharedDigit(int number1, int number2) {
        if (number1 < 10 || number2 < 10 || number1 > 99 || number2 > 99)
            return false;
        int number2b = number2;
        while (number1 > 0) {
            while (number2b > 0) {
                if (number1 % 10 == number2b % 10)
                    return true;
                number2b /= 10;
            }
            number1 /= 10;
            number2b = number2;
        }
        return false;
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        int number2 = 0;
        int total = 0;
        while (number > 0) {
            number2 = number % 10;
            if (number2 % 2 == 0) {
                total += number2;
            }
            number /= 10;
        }
        return total;
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        } else if (number < 10) {
            return number * 2;
        } else {
            int first = number % 10;
            int last = number / 10;
            while (last >= 10) {
                last /= 10;
            }
            return last + first;
        }
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        if (number < 0)
            number *= -1;
        int number2 = number;
        do {
            reverse += number2 % 10;
            number2 /= 10;
            reverse *= 10;
        } while (number2 > 0);
        reverse /= 10;
        return number == reverse;
    }

    public static int sumDigits(int number) {
        if (number < 10)
            return -1;
        int digit = number % 10;
        int sum = 0;
        while (number > 0) {
            sum += digit;
            number /= 10;
            digit = number % 10;
        }
        return sum;
    }

    public static boolean isEvenNumber(int number) {
        return (number % 2 == 0);
    }

    public static void printAnswer(String answer) {
        System.out.println(answer);
    }
}
