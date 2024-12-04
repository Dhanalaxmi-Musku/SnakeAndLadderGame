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

}
