package Question4;

public class ProducerConsumerDemo {
    private Buffer buffer;

    public ProducerConsumerDemo(Buffer buffer) {
        this.buffer = buffer;
    }

    public void produce() {
        for (int i = 0; i < 5; i++) {
            try {
                buffer.produce(i);
                System.out.println("Produced: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        for (int i = 0; i < 5; i++) {
            try {
                int item = buffer.consume();
                System.out.println("Consumed: " + item);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

