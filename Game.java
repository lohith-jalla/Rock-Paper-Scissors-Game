import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name to Start Game:");
        String name = sc.next();
        gameSimulator games = new gameSimulator();
        int n = 0;
        do {
            System.out.println("Enter Options from Menu");
            System.out.println("\n1. Start Game\n2. Score\n3. End Game");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    games.game(name);
                    break;
                case 2:
                    System.out.println("User Score: " + games.getUserScore());
                    System.out.println("Computer Score: " + games.getComputerScore());
                    break;
                case 3:
                    n = -1;
                    break;
                default:
                    System.out.println("Invalid option. Please select from the menu.");
                    break;
            }
        } while (n != -1);
    }
}

class gameSimulator {
    private int userScore = 0;
    private int computerScore = 0;

    public void game(String name) {
        String[] parameters = { "Rock", "Paper", "Scissors" };

        Scanner sc = new Scanner(System.in);
        System.out.println("Select a parameter: Rock, Paper, Scissors");
        String userInput = sc.nextLine().toLowerCase();
        String computerInput = parameters[(int) (Math.random() * 3)].toLowerCase();  // Normalize computer input

        if (userInput.equals(computerInput)) {
            System.out.println("It's a Draw!");
        } else if (userInput.equals("rock") && computerInput.equals("scissors") ||
                userInput.equals("scissors") && computerInput.equals("paper") ||
                userInput.equals("paper") && computerInput.equals("rock")) {
            System.out.println("You Won!");
            System.out.println("Computer selected: " + computerInput);
            userScore++;
        } else if (userInput.equals("rock") && computerInput.equals("paper") ||
                userInput.equals("scissors") && computerInput.equals("rock") ||
                userInput.equals("paper") && computerInput.equals("scissors")) {
            System.out.println("Computer Won!");
            System.out.println("Computer selected: " + computerInput);
            computerScore++;
        } else {
            System.out.println("Invalid input! Please select Rock, Paper, or Scissors.");
        }

        System.out.println("Your Score: " + userScore);
        System.out.println("Computer Score: " + computerScore);
    }

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
