package homework02;

public class WinnerBoard {
    private int winner = -1;

    synchronized void trySetWinner(int tarakanNumber) {
        if (winner == -1) {
            winner = tarakanNumber;
        }
    }

    synchronized int getWinner() {
        return winner;
    }
}
