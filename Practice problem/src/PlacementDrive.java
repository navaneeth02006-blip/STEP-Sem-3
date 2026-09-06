import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    public double cgpa;
    public int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // CGPA + coding score eligibility
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Compare candidates by coding score
    public int compareTo(Candidate other) {
        return other.codingScore - this.codingScore;
    }

    public String toString() {
        return name + " (" + cgpa + ")";
    }
}

public class PlacementDrive {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {

            if (Candidate.isEligible(c.cgpa)) {
                shortlisted[count] = c;
                count++;
            }
            else if (Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count] = c;
                count++;
            }
        }

        // Sort by coding score
        Arrays.sort(shortlisted, 0, count);

        String result = "";

        for (int i = 0; i < count; i++) {
            result += (i + 1) + ". " + shortlisted[i];

            if (i < count - 1)
                result += " | ";
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}