package homework02;

public class TarakanRace {
    private static final int SLEEP_MIN = 2;
    private static final int SLEEP_MAX = 5;
    private final int distance;
    private final int tarakanCount;

    public TarakanRace(int distance, int tarakanCount) {
        this.distance = distance;
        this.tarakanCount = tarakanCount;
    }

    public void startRace() throws InterruptedException {
        WinnerBoard winner = new WinnerBoard();
        Thread[] tarakans = new Thread[tarakanCount];

        for (int i = 0; i < tarakanCount; i++) {
            tarakans[i] = new Thread(new Tarakan(i + 1, distance, SLEEP_MIN, SLEEP_MAX, winner));
            tarakans[i].start();
        }

        for (Thread tarakan : tarakans) {
            tarakan.join();
        }

        System.out.printf("Congratulations to tarakan #%d (winner)%n", winner.getWinner());
    }
}
