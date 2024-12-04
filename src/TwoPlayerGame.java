import java.util.Random;

public class TwoPlayerGame {
	private static final int WINNING_POSITION = 100;
    private static final int START_POSITION = 0;
	private int player1Position;
    private int player2Position;
    private int player1DiceRollCount;
    private int player2DiceRollCount;
    private Random random;

    public TwoPlayerGame() {
        this.player1Position = START_POSITION;
        this.player2Position = START_POSITION;
        this.player1DiceRollCount = 0;
        this.player2DiceRollCount = 0;
        this.random = new Random();
    }

    private int rollDie() {
        return random.nextInt(6) + 1;
    }

    private int determineGameOption() {
        return random.nextInt(3);
    }

    public void play() {
        boolean player1Turn = true;

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            int dieRoll = rollDie();
            int gameOption = determineGameOption();

            if (player1Turn) {
                player1DiceRollCount++;
                System.out.println("Player 1's Turn - Dice Roll: " + dieRoll + 
                    ", Option: " + getOptionName(gameOption));

                player1Position = updatePosition(player1Position, dieRoll, gameOption);
                System.out.println("Player 1 Position: " + player1Position);
                if (gameOption != 1) {
                    player1Turn = false;
                }
            } else {
                player2DiceRollCount++;
                System.out.println("Player 2's Turn - Dice Roll: " + dieRoll + 
                    ", Option: " + getOptionName(gameOption));

                player2Position = updatePosition(player2Position, dieRoll, gameOption);
                System.out.println("Player 2 Position: " + player2Position);
                if (gameOption != 1) {
                    player1Turn = true;
                }
            }
        }
        System.out.println("\nGame Completed!");
        if (player1Position >= WINNING_POSITION) {
            System.out.println("Player 1 Wins!");
            System.out.println("Player 1 Dice Rolls: " + player1DiceRollCount);
            System.out.println("Player 2 Dice Rolls: " + player2DiceRollCount);
        } else {
            System.out.println("Player 2 Wins!");
            System.out.println("Player 1 Dice Rolls: " + player1DiceRollCount);
            System.out.println("Player 2 Dice Rolls: " + player2DiceRollCount);
        }
    }

    private int updatePosition(int currentPosition, int dieRoll, int gameOption) {
        switch (gameOption) {
            case 0: // No Play
                return currentPosition;
            case 1: // Ladder
                currentPosition += dieRoll;
                break;
            case 2: // Snake
                currentPosition -= dieRoll;
                break;
        }
        currentPosition = Math.max(START_POSITION, currentPosition);
        if (currentPosition > WINNING_POSITION) {
            currentPosition -= dieRoll;
        }

        return currentPosition;
    }

    private String getOptionName(int option) {
        switch (option) {
            case 0: return "No Play";
            case 1: return "Ladder";
            case 2: return "Snake";
            default: return "Unknown";
        }
    }

}
