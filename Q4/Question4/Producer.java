package Question4;

import java.util.Random;

public class Producer implements Runnable {
    private ThreadSafeQueue<Integer> queue;

    public Producer(ThreadSafeQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            try {
                queue.enqueue(num);
                System.out.println("Produced: " + num);
                Thread.sleep(rand.nextInt(1000)); // Sleep for up to 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

