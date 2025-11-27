package ait.multithreading;

import ait.multithreading.task.MyTaskExtends;
import ait.multithreading.task.MyTaskImplements;

public class MultithreadingAppl {
    private static final int MAX = 10;
    private static final int SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running.");
        Runnable task1 = new MyTaskImplements("TaskImplements", MAX);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new MyTaskExtends("TaskExtends", MAX);
        Runnable[] tasks = new Runnable[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tasks[i] = new MyTaskImplements("Name# " + i, MAX);
        }
        Thread[] threads = new Thread[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            threads[i] = new Thread(tasks[i]);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
//            threads[i].join(); // Wrong way!!!
        }
        thread1.start();
        thread2.start();
        for (int i = 0; i < MAX; i++) {
            System.out.println("Thread: main, count: " + i);
            Thread.sleep(1); // Simulate some work with a sleep
        }
        thread1.join();
        thread2.join();
        System.out.println("Main thread is finished.");
    }
}
