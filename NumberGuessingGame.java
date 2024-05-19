import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7;
    private static final int NUMBER_RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(NUMBER_RANGE) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A number between 1 and " + NUMBER_RANGE + " has been generated. Try to guess it!");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    totalScore += MAX_ATTEMPTS - attempts + 1; // The sooner the guess, the higher the score.
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all " + MAX_ATTEMPTS + " attempts. The number was: " + numberToGuess);
            }

            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your total score is: " + totalScore);
        scanner.close();
    }
}
