package homework02;

import java.util.concurrent.ThreadLocalRandom;

public class Tarakan implements Runnable {
    private final int number;
    private final int distance;
    private final int sleepMin;
    private final int sleepMax;
    private final WinnerBoard winner;

    public Tarakan(int number, int distance, int sleepMin, int sleepMax, WinnerBoard winner) {
        this.number = number;
        this.distance = distance;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
        this.winner = winner;
    }

    @Override
    public void run() {
        for (int i = 0; i <= distance; i++) {
            System.out.printf("Tarakan #%d >>> step %d/%d%n", number, i, distance);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(sleepMin, sleepMax + 1));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        winner.trySetWinner(number);
    }
}
