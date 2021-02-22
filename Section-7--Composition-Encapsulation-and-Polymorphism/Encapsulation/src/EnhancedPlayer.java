public class EnhancedPlayer {
  private String name;
  private int hitPoints;
  private String weapon;

  public EnhancedPlayer(String name, int hitPoints, String weapon) {
    this.name = name;
    if (hitPoints > 0 && hitPoints <= 100) {
      this.hitPoints = hitPoints;
    }
    this.weapon = weapon;
  }

  public void loseHealth(int damage) {
    this.hitPoints -= damage;
    if (this.hitPoints <= 0) {
      System.out.println("Player knocked out");
      //reduce number of lives remaining for the player
    }
  }

  public int getHealth() {
    return hitPoints;
  }

  public String getName() {
    return name;
  }
}
