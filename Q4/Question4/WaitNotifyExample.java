package Question4;

public class WaitNotifyExample {
    public synchronized void waitMethod() {
        System.out.println(Thread.currentThread().getName() + " waiting...");
        try {
            wait(); // Releases the lock and waits until another thread calls notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " resumed.");
    }

    public synchronized void notifyMethod() {
        try {
            Thread.sleep(2000); // Sleep for 2 seconds before notifying
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify(); // Notifies the waiting thread to resume
    }
}
