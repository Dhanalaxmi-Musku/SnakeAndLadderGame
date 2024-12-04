import java.util.Random;

public class SinglePlayerGame {
	private static final int WINNING_POSITION = 100;
    private static final int START_POSITION = 0;
    private int playerPosition;
    private int diceRollCount;
    private Random random;
    public SinglePlayerGame() {
        this.playerPosition = START_POSITION;
        this.diceRollCount = 0;
        this.random = new Random();
    }
    public int rollDie() {
        diceRollCount++;
        return random.nextInt(6) + 1;
    }
    public int determineGameOption() {
        int option = random.nextInt(3);
        switch (option) {
            case 0: return 0;  // No Play
            case 1: return 1;  // Ladder
            case 2: return 2;  // Snake
            default: return 0;
        }
    }
    public void play() {
        while (playerPosition < WINNING_POSITION) {
            int dieRoll = rollDie();
            int gameOption = determineGameOption();
            System.out.println("Dice Roll: " + dieRoll + ", Option: " + 
                (gameOption == 0 ? "No Play" : (gameOption == 1 ? "Ladder" : "Snake")));

            switch (gameOption) {
                case 0: // No Play
                    break;
                case 1: // Ladder
                    playerPosition += dieRoll;
                    break;
                case 2: // Snake
                    playerPosition -= dieRoll;
                    break;
            }
            playerPosition = Math.max(START_POSITION, playerPosition);
            if (playerPosition > WINNING_POSITION) {
                playerPosition -= dieRoll;
            }
            System.out.println("Current Position: " + playerPosition);
        }
        System.out.println("Game Completed!");
        System.out.println("Total Dice Rolls: " + diceRollCount);
    }

}
