public class App {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player();
        player1.name = "BadPlayer";
        player1.health = 20;
        player1.weapon = "Sword";

        int damage = 10;
        player1.loseHealth(damage);
        System.out.println(player1.name + " health = " + player1.healthRemaining());
        damage = -10;
        player1.loseHealth(damage);
        System.out.println(player1.name + " remaining health = " + player1.healthRemaining());

        EnhancedPlayer player2 = new EnhancedPlayer("GoodPlayer", 20, "Sword");
        System.out.println(player2.getName() + " health is " + player2.getHealth());

    }
}
