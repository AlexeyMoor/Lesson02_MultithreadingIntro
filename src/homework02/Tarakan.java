package homework02;

import java.util.Random;

public class Tarakan implements Runnable {
    private final static Object monitor = new Object();
    private static int distance;
    private static int minSleepTime = 2;
    private static int maxSleepTime = 5;
    private static String winner;
    private static Random random = new Random();
    private String name;

    public Tarakan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getWinner() {
        return winner;
    }

    public static void setDistance(int distance) {
        Tarakan.distance = distance;
    }

    public static void setMinSleepTime(int minSleepTime) {
        Tarakan.minSleepTime = minSleepTime;
    }

    public static void setMaxSleepTime(int maxSleepTime) {
        Tarakan.maxSleepTime = maxSleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < distance; i++) {
            int sleepTime = random.nextInt(minSleepTime, maxSleepTime + 1);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
        synchronized (monitor) {
            if (winner == null) {
                winner = name;
            }
        }
    }
}