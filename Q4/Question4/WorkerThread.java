package Question4;

import java.util.Random;

public class WorkerThread implements Runnable {
    private String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started.");
        Random rand = new Random();
        try {
            Thread.sleep(rand.nextInt(5000)); // Sleep for up to 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished.");
    }
}
