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

}
