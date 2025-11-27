package ait.multithreading.task;

public class MyTaskExtends extends Thread {
    private final String name;
    private final int max;

    public MyTaskExtends(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        System.out.println("Task: " + name + " is running.");
        for (int i = 0; i <= max; i++) {
            System.out.println("Task: " + name + ", count: " + i);
            try {
                Thread.sleep(1); // Simulate some work with a sleep
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Task: " + name + " is finished.");
    }
}

