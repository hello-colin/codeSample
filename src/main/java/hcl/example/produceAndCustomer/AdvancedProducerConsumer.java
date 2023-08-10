package hcl.example.produceAndCustomer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvancedProducerConsumer {
    private static final int CAPACITY = 5;
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(CAPACITY);
    private final ExecutorService producerExecutor = Executors.newFixedThreadPool(2);
    private final ExecutorService consumerExecutor = Executors.newFixedThreadPool(2);

    public void produce(int  item) {
        producerExecutor.submit(() -> {
            try {
                queue.put(item);
                System.out.println("Produced: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void consume() {
        consumerExecutor.submit(() -> {
            try {
                int item = queue.take();
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void shutdown() {
        producerExecutor.shutdown();
        consumerExecutor.shutdown();
    }

    public static void main(String[] args) {
        AdvancedProducerConsumer pc = new AdvancedProducerConsumer();

        for (int i = 0; i < 10; i++) {
            pc.produce(i);
            pc.consume();
        }

        pc.shutdown();
    }
}
