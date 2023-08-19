import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner cont = new Scanner(System.in);
    public static void main(String[] args) {
        numberGame();
    }
    public static void numberGame(){
        System.out.println("Welcome to Number Game\n");
        boolean quit = false; // Loop breaking parameter
        int round = 1; // keeping track of rounds
        int noOfAttempts = 5;
        int scorePerAttempts = 20; // the score deducts per incorrect answer
        int initialScore = noOfAttempts*scorePerAttempts; // initial score
        int currentScore = initialScore;
        int roundsWon = 0; // keeping track of won rounds
        do{
            Random random = new Random();
            int correctNumber = Math.abs(random.nextInt()%100); // Generating a random number between 1 and 100
            boolean isCorrect = false;
            System.out.println("Round "+round);
            System.out.println("A number between 1 and 100 has been generated.");
            System.out.println("Now you have to guess that number within " + noOfAttempts +" attempts.");
            for(int i = 1;i<=noOfAttempts;i++){
                System.out.println("Guess the number: ");
                int guess = scanner.nextInt();
                if(guess == correctNumber){
                    System.out.println("You have guessed the correct number!");
                    System.out.println("Your Score: "+currentScore);
                    roundsWon++; // won the round
                    isCorrect = true;
                    break;
                }
                else if(guess > correctNumber){
                    System.out.println("You have guessed a higher number!");
                }
                else{
                    System.out.println("You have guessed a lower number!");
                }
                if((noOfAttempts - i) != 0){ // executes if the answer is incorrect
                    System.out.println("You have "+ (noOfAttempts - i)+" attempt(s) left");
                    currentScore  -= scorePerAttempts; // score deducts
                }
            }
            if(!isCorrect){
                System.out.println("You have exhausted all of your attempts.\nBetter luck next time!");
                currentScore -= scorePerAttempts;
                System.out.println("Your Score: " + currentScore);
            }
            System.out.println("Continue? (yes/no): ");
            String choice = cont.next();
            if(choice.equalsIgnoreCase("no")){
                quit = true;
            }
            else {
                round++;
                currentScore += initialScore;  // score increases by the initial amount if the player chooses to continue
            }
        }while (!quit); // terminating condition
        System.out.println("Round(s) won: "+roundsWon);
        System.out.println("Your Final Score: "+currentScore);
        System.out.println("Thank you for playing the game!");
    }
}