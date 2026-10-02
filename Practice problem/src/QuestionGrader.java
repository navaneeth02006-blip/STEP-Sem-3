import java.util.*;
import java.util.regex.*;

interface Question {
    double calculateScore(String studentAnswer);
}
class MCQ implements Question {
    String correctAnswer;
    double points;
    MCQ(String correctAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.points = points;
    }
    public double calculateScore(String studentAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer))
            return points;
        return 0;
    }
}
class TrueFalse implements Question {
    String correctAnswer;
    double points;

    TrueFalse(String correctAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public double calculateScore(String studentAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer))
            return points;
        return 0;
    }
}
class Essay implements Question {
    String[] keywords;
    double points;

    Essay(String correctAnswer, double points) {
        keywords = correctAnswer.split(",");
        this.points = points;
    }
    public double calculateScore(String studentAnswer) {

        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase()
                    .contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }
        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}
public class QuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double totalScore = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            Matcher matcher = pattern.matcher(line);

            ArrayList<String> values = new ArrayList<>();

            while (matcher.find()) {
                values.add(matcher.group(1));
            }
            String type = line.substring(0, line.indexOf(" "));
            String[] parts = line.trim().split(" ");
            double points = Double.parseDouble(parts[parts.length - 1]);

            Question question;
            String studentAnswer;

            if (type.equals("MCQ")) {

                String correctAnswer = values.get(2);
                studentAnswer = values.get(1);

                question = new MCQ(correctAnswer, points);

            } else if (type.equals("TF")) {

                String correctAnswer = values.get(2);
                studentAnswer = values.get(1);

                question = new TrueFalse(correctAnswer, points);

            } else {

                String correctAnswer = values.get(1);
                studentAnswer = values.get(2);

                question = new Essay(correctAnswer, points);
            }
            double score = question.calculateScore(studentAnswer);
            totalScore += score;
            System.out.printf("%s: %.2f%n%n", type, score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}