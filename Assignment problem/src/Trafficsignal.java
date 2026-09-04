import java.util.Scanner;

public class Trafficsignal{

    static void findLongestStreak(String signalLog) {

        char currentColor = signalLog.charAt(0);
        int currentCount = 1;

        char longestColor = currentColor;
        int longestCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {
                currentCount++;
            } else {

                if (currentCount > longestCount) {
                    longestCount = currentCount;
                    longestColor = currentColor;
                }

                currentColor = signalLog.charAt(i);
                currentCount = 1;
            }
        }

        if (currentCount > longestCount) {
            longestCount = currentCount;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestCount + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log (R/Y/G): ");
        String signalLog = sc.nextLine();

        if (signalLog.length() == 0) {
            System.out.println("Signal log cannot be empty.");
        } else {
            findLongestStreak(signalLog);
        }

        sc.close();
    }
}