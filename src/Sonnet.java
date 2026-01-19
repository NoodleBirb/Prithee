import java.util.Scanner;

public class Sonnet {
    private int correct; // Times user is correct
    private int incorrect; // Times user is incorrect
    private final String[] SONNET;

    public Sonnet(String sonnet) {
        SONNET = sonnet.split(" ");
        correct = 0;
        incorrect = 0;
    }
    public boolean GameOver() {
        if (correct >= 3) {
            System.out.println("Congratulations, you win!");
            return true;
        } else if (incorrect >= 3) {
            System.out.println("You lose :(");
            return true;
        }
        return false;
    }
    public void PlayRound() {
        PlayIndexRound((int)(Math.random() * SONNET.length));
    }
    public void PlayIndexRound(int sonnetWordInd) {
        for (int i = 0; i < sonnetWordInd; i++) {
            System.out.print(SONNET[i] + " ");
        }
        System.out.print("_".repeat(SONNET[sonnetWordInd].length()));
        Scanner s1 = new Scanner(System.in);
        System.out.println();
        System.out.print("What is the next word?");
        String guess = s1.nextLine();
        System.out.println();
        if (guess != null && guess.equals(SONNET[sonnetWordInd])) {
            correct++;
            System.out.println("Good job, you got it right!");
        } else {
            incorrect++;
            System.out.println("Sorry, the correct word was \"" + SONNET[sonnetWordInd] + "\"");
        }
    }
    public int getCorrect() {
        return correct;
    }
    public int getIncorrect() {
        return incorrect;
    }

}
