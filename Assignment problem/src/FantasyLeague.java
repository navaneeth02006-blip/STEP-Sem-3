import java.util.Arrays;

class Player implements Comparable<Player> {

    private String name;
    public int matchesPlayed;
    public double battingAverage;
    public boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // For experienced players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // For newer players
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Sort by fantasy points
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints(), this.fantasyPoints());
    }

    // Calculate fantasy points
    double fantasyPoints() {
        return battingAverage + matchesPlayed;
    }

    public String toString() {
        return name;
    }
}

public class FantasyLeague{

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {

            if (Player.isDraftable(p.matchesPlayed)) {
                draftable[count] = p;
                count++;
            }
            else if (Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count] = p;
                count++;
            }
        }

        Arrays.sort(draftable, 0, count);

        String result = "";

        for (int i = 0; i < count; i++) {
            result += (i + 1) + ". " + draftable[i];

            if (i < count - 1)
                result += " | ";
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}