package Question4;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // a) Create and start multiple threads
        for (int i = 0; i < 5; i++) {
            executor.execute(new WorkerThread("Thread " + i));
        }

        // b) Synchronize threads to avoid race conditions and ensure data consistency
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            executor.execute(new CounterThread(counter));
        }

        // c) Use wait() and notify() to implement thread communication
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        executor.execute(() -> waitNotifyExample.waitMethod());
        executor.execute(() -> waitNotifyExample.notifyMethod());

        // d) Use sleep() to pause threads for a specified duration
        executor.execute(() -> {
            try {
                System.out.println("Sleeping for 2 seconds...");
                Thread.sleep(2000);
                System.out.println("Awake after sleeping.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // e) Demonstrate thread interruption and thread termination
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task completed.");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted.");
            }
        });

        executor.shutdown();

        // f) Use thread pools to manage a group of threads efficiently
        // g) Implement thread synchronization using locks and conditions
        ThreadSafeQueue<Integer> threadSafeQueue = new ThreadSafeQueue<>();
        Producer producer = new Producer(threadSafeQueue);
        Consumer consumer = new Consumer(threadSafeQueue);
        executor = Executors.newFixedThreadPool(2);
        executor.execute(producer);
        executor.execute(consumer);

        // h) Demonstrate deadlock and ways to avoid it
        Object lock1 = new Object();
        Object lock2 = new Object();
        DeadlockThread t1 = new DeadlockThread(lock1, lock2);
        DeadlockThread t2 = new DeadlockThread(lock2, lock1);
        executor.execute(t1);
        executor.execute(t2);

        // i) Use thread-local variables to handle thread-specific data
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        executor.execute(() -> threadLocalExample.setValue(10));
        executor.execute(() -> threadLocalExample.printValue());

        // j) Implement producer-consumer problem using thread synchronization
        Buffer buffer = new Buffer(5);
        ProducerConsumerDemo producerConsumerDemo = new ProducerConsumerDemo(buffer);
        executor.execute(() -> producerConsumerDemo.produce());
        executor.execute(() -> producerConsumerDemo.consume());

        // k) Use Executors and Callable to perform parallel computation and get results
        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum;
        };
        Future<Integer> future = executor.submit(task);
        try {
            System.out.println("Sum of numbers from 1 to 5: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

