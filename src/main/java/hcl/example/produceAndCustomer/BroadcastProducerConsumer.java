package hcl.example.produceAndCustomer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BroadcastProducerConsumer {
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == CAPACITY) {
                notFull.await();
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BroadcastProducerConsumer pc = new BroadcastProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.produce(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.consume();
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.consume();
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

        try {
            producerThread.join();
            consumerThread1.join();
            consumerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
