package Question4;

public class DeadlockThread implements Runnable {
    private Object lock1;
    private Object lock2;

    public DeadlockThread(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock1.");
            try {
                Thread.sleep(100); // Introduce delay to make deadlock easier to observe
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " waiting for lock2.");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2.");
            }
        }
    }
}
