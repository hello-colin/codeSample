package hcl.example.produceAndCustomer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ConditionTest {

    private static final int CAPACITY = 1;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == CAPACITY) {
                notFull.await();
                System.out.println("生产满了");
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        System.out.println("消费者尝试获取锁");
        lock.lock();
        System.out.println("开始消费");
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

    public static void main(String[] args) throws InterruptedException {
        ConditionTest pc = new ConditionTest();

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    pc.produce(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 1; i++) {
                    pc.consume();
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        Thread.sleep(5000);
        consumerThread.start();

        pc.lock.lock();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
