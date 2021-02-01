public class App {
    public static void main(String[] args) {
        /*
         * a mile is equal to 1.609344 miles double kilometers = (100 * 1.609344); int
         * highScore = 50;
         * 
         * if(highScore == 50) { System.out.println("This is an expression"); } //
         * expressions are score = 100, score > 99, "You got the high score!", score = 0
         * int score = 100; if (score > 99) {
         * System.out.println("You got the high score!"); score = 0; }
         * 
         * // STATMENTS WHITESPACE AND INDENTING int myVariable = 50; myVariable++;
         * myVariable--; System.out.println("This is a test");
         * System.out.println("This is" + "another" + "and still more"); int
         * anotherVarialbe = 50; myVariable--;System.out.println("This is another one");
         * // Java ignores white space completely - only important for readability if
         * (myVariable == 50) { myVariable = 50; }
         */
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        // calculateScore(true, 800, 5, 100)
        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);
        /*
         * if(score == 5000) System.out.println("Your score was 5000"); if(score ==
         * 5000) System.out.println("Your score was 5000");
         * System.out.println("this prints no matter what"); if(score != 5000) {
         * System.out.println("Your score was NOT 5000");
         * System.out.println("this shoudn't print"); } if (score < 5000 && score >
         * 1000) { System.out.println("your score was less than 5000"); } else if(score
         * < 1000) { System.out.println("your score was less than 1000"); } else {
         * System.out.println("Got Here!"); }
         * 
         * 
         * if (gameOver) { int finalScore = score + (levelCompleted * bonus);
         * System.out.println("Your final score was " + finalScore); } //
         * System.out.println(finalScore); will not work outside the codeblock because
         * of scope
         */
        score = 10000;
        levelCompleted = 8;
        bonus = 200;
        // calculateScore(true, 10000, 5, 200)
        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);

        String playerName1 = "Score1";
        int score1 = 1500;
        displayHighScorePosition(playerName1, caluculateHighScorePosition(score1));

        String playerName2 = "Score2";
        int score2 = 900;
        displayHighScorePosition(playerName2, caluculateHighScorePosition(score2));

        String playerName3 = "Score3";
        int score3 = 400;
        displayHighScorePosition(playerName3, caluculateHighScorePosition(score3));

        String playerName4 = "Score4";
        int score4 = 50;
        displayHighScorePosition(playerName4, caluculateHighScorePosition(score4));

        String playerName5 = "Score5";
        int score5 = 1000;
        displayHighScorePosition(playerName5, caluculateHighScorePosition(score5));
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            return score + (levelCompleted * bonus);
        }
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int playerPosition) {
        System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score table");
    }

    public static int caluculateHighScorePosition(int score) {
        int position = 4;
        if(score >= 1000){
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }
        return position;
    }

}
