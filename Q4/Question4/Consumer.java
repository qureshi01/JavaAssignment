package Question4;

public class Consumer implements Runnable {
    private ThreadSafeQueue<Integer> queue;

    public Consumer(ThreadSafeQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int num = queue.dequeue();
                System.out.println("Consumed: " + num);
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

