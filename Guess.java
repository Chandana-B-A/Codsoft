import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int MAX_ATTEMPTS = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        int attempts = 0;
        int correctNumber = generateRandomNumber();
        boolean playAgain = true;

        while (playAgain) {
            int userGuess = getUserGuess();
            attempts++;

            if (userGuess == correctNumber) {
                System.out.println("Congratulations, you guessed the number in " + attempts + " attempts!");
                playAgain = askToPlayAgain();
            } else if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Game over. The correct number was " + correctNumber + ".");
                playAgain = askToPlayAgain();
            } else {
                provideFeedback(userGuess, correctNumber);
            }
        }
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    private static int getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (1-" + MAX_NUMBER + "): ");
        return scanner.nextInt();
    }

    private static void provideFeedback(int userGuess, int correctNumber) {
        if (userGuess < correctNumber) {
            System.out.println("Your guess is too low. Try again!");
        } else if (userGuess > correctNumber) {
            System.out.println("Your guess is too high. Try again!");
        }
    }

    private static boolean askToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }
}
