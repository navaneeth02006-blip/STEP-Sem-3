import java.util.*;

public class Stopword{

    static void printFilteredWordFrequency(String feedback) {

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of"};

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                if (frequency.containsKey(words[i])) {
                    frequency.put(words[i], frequency.get(words[i]) + 1);
                } else {
                    frequency.put(words[i], 1);
                }
            }
        }

        ArrayList<String> wordsList =
                new ArrayList<>(frequency.keySet());

        Collections.sort(wordsList, new Comparator<String>() {
            public int compare(String a, String b) {
                return frequency.get(b) - frequency.get(a);
            }
        });

        for (String word : wordsList) {
            System.out.println(word + ": " + frequency.get(word));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}