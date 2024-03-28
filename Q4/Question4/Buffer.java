package Question4;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> queue;
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if the buffer is full
        }
        queue.offer(item);
        notifyAll(); // Notify consumers that an item is produced
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the buffer is empty
        }
        int item = queue.poll();
        notifyAll(); // Notify producers that an item is consumed
        return item;
    }
}


