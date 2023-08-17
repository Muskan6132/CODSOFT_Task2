package numberGuess;
	import java.util.Random;
	import java.util.Scanner;

	public class NumberGuessingGame {
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        int minNum = 1;
	        int maxNum = 100;
	        int maxAttempts = 3;
	        int totalAttempts = 0;
	        int rounds = 0;

	        boolean playAgain = true;
	        while (playAgain) {
	        	System.out.println("Welcome to Muskan "
	        			+ ""
	        			+ "Gaming Word.... ");
	            System.out.println("===== Guess the Number Game =====");
	            rounds++;
	            System.out.println("Round " + rounds);
	            totalAttempts += playRound(minNum, maxNum, random, scanner);

	            if (rounds >= maxAttempts || !playAgain(scanner)) {
	                playAgain = false;
	            }
	        }

	        System.out.println("\nGame Over! You played " + rounds + " rounds and took an average of " + (double) totalAttempts / rounds + " attempts per round.");
	    }

	    public static int playRound(int minNum, int maxNum, Random random, Scanner scanner) {
	        int targetNumber = random.nextInt(maxNum - minNum + 1) + minNum;
	        int attempts = 0;

	        while (true) {
	            System.out.print("Guess a number between " + minNum + " and " + maxNum + ": ");
	            int userGuess = scanner.nextInt();
	            attempts++;

	            if (userGuess == targetNumber) {
	                System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
	                return attempts;
	            } else if (userGuess < targetNumber) {
	                System.out.println("Too low! Try again.");
	            } else {
	                System.out.println("Too high! Try again.");
	            }
	        }
	    }

	    public static boolean playAgain(Scanner scanner) {
	        System.out.print("Play again? (yes/no): ");
	        String response = scanner.next().toLowerCase();
	        return response.equals("yes");
	    }
	}

