import java.util.Scanner;

// Interface for game modes
interface GameMode {
    void start();
}

// Interface for player actions
interface Player {
    String getName();
}

// Interface for the game
interface Game {
    void play();
}

// Class representing a player
class GamePlayer implements Player {
    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Class for Story mode
class StoryMode implements GameMode {
    private Player player;

    public StoryMode(Player player) {
        this.player = player;
    }

    @Override
    public void start() {
        System.out.println("Starting Story Mode for " + player.getName() + "...");
        System.out.println("Once upon a time...");
        // Add more story elements here
    }
}

// Class for Survival mode
class SurvivalMode implements GameMode {
    private Player player;

    public SurvivalMode(Player player) {
        this.player = player;
    }

    @Override
    public void start() {
        System.out.println("Starting Survival Mode for " + player.getName() + "...");
        System.out.println("You are stranded on an island...");
        // Add more survival elements here
    }
}

// Class for the game logic
class ConsoleGame implements Game {
    private Player player;
    private GameMode gameMode;

    public ConsoleGame(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                gameMode = new StoryMode(player);
                break;
            case 2:
                gameMode = new SurvivalMode(player);
                break;
            default:
                System.out.println("Invalid choice. Exiting game.");
                return;
        }

        System.out.printf("Press P to start playing, %s.\n", player.getName());
        String start = scanner.next();
        if (start.equalsIgnoreCase("P")) {
            gameMode.start();
        } else {
            System.out.println("Game not started.");
        }

        scanner.close();
    }
}

// Main class to run the game
public class TextBasedGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new GamePlayer(name);
        Game game = new ConsoleGame(player);
        game.play();

        scanner.close();
    }
}
