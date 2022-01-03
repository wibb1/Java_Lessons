public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        **These won't work because they are the incorrect player type**
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago White Sox");
        baseballTeam.addPlayer(pat);
//      **
//      Team<String> brokenTeam = new Team<>("This won't work but doesn't error before compilation
//      if we cast to player in addPlayer - it throws an exception at runtime.");
//      by changing the Team class from Team<T> to Team<T extends Player> we are able to eliminate
//      these issues and limit the team to include only and arraylist of players - this removes the
//      need for a cast in the code below
//        **OLD CODE IN TEAM**
//        public boolean addPlayer(T player) {
//            if (members.contains(player)) {
//                System.out.println(((Player) player).getName() + " is already on " + this.name);
//                return false;
//            } else {
//                members.add(player);
//                System.out.println(((Player) player).getName() + " picked for team " + this.name);
//                return true;
//            }
//        }

        Team<SoccerPlayer> soccerTeam = new Team<>("Soccer Club");
        soccerTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordan");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorne = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorne.matchResult(fremantle, 1, 0);
        hawthorne.matchResult(adelaideCrows, 3, 8);
        adelaideCrows.matchResult(fremantle, 2, 1);
//        **to stop the following code from executing added <T> to **
//        public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
//        adelaideCrows.matchResult(baseballTeam, 1, 1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorne.getName() + ": " + hawthorne.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorne));
        System.out.println(hawthorne.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));
    }
}
