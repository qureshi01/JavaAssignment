package Question4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSafeQueue<T> {
    private BlockingQueue<T> queue;

    public ThreadSafeQueue() {
        queue = new LinkedBlockingQueue<>();
    }

    public void enqueue(T element) throws InterruptedException {
        queue.put(element);
    }

    public T dequeue() throws InterruptedException {
        return queue.take();
    }
}

