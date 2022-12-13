import java.util.*;

public class GuessingGame {
	public static final int MAX = 100;
	
	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		Random numberGenerator = new Random();

		int games = 0;
		int bestGuess = 10000;
		int totalGuesses = 0;
		int testGuess = 0;
		String choice = "";
		Boolean gameOver = false;
		
		gameStart();		
			
		while (gameOver == false) {
			testGuess = runGame(console, totalGuesses, numberGenerator);
			totalGuesses += testGuess;

			if (testGuess < bestGuess) {
				bestGuess = testGuess;
			}
			
			games++;
			
			System.out.print("Do you want to play again? ");
			choice = console.next();
            System.out.println();
			
			if (choice.toLowerCase().equals("n")) {
				gameOver = true;
			}
		}
		
		gameStats(bestGuess, games, totalGuesses);
	}
	
	public static void gameStart() {
		System.out.println("Welcome to my game.");
        System.out.println("You get to guess a number.");
        System.out.println("Good luck and have fun!");
	}
	
	public static int runGame(Scanner console, int totalGuesses, Random numberGenerator) {
		System.out.println();
		System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
		
		int number = numberGenerator.nextInt(MAX) + 1;
		Boolean gameOver = false;
		int nOfGuesses = 0;
		
		while (gameOver == false) {
			System.out.print("Your guess? ");
			int guess = console.nextInt();
			nOfGuesses++;
			totalGuesses += nOfGuesses;
			if (guess == number) {
				System.out.println("You got it right in " + nOfGuesses + " guesses!");
				gameOver = true;
			} else if (guess > number) {
				System.out.println("It's lower.");
			} else {
				System.out.println("It's higher.");
			}
		}
		return nOfGuesses;
	}
	
	public static void gameStats(int bestGuess, int games, int totalGuesses) {
		System.out.println("Overall results:");
		System.out.println("Total games   = " + games);
		System.out.println("Total guesses = " + totalGuesses);
		System.out.println("Guesses/game  = " + roundNumber(totalGuesses/games));
		System.out.println("Best game     = " + bestGuess);
	}
	
	public static double roundNumber(double number) {
		return (Math.round(number * 10)) / 10.0;
	}
}