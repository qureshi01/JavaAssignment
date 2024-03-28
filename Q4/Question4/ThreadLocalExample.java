package Question4;

public class ThreadLocalExample {
    private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void setValue(int value) {
        threadLocal.set(value);
    }

    public void printValue() {
        System.out.println("Thread " + Thread.currentThread().getName() + ": " + threadLocal.get());
    }
}
