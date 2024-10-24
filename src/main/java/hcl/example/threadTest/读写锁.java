package hcl.example.threadTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁 {
    public static void main(String[] args) {

        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        Semaphore semaphore=new Semaphore(5);
        Thread.interrupted();

        Runnable readTask = () -> {
            Lock readLock = rwLock.readLock();
            try {
                readLock.lock();
                System.out.println(Thread.currentThread().getName() + " is reading");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " read over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        };

        // Simulate concurrent read operations
        for (int i = 0; i < 5; i++) {
            new Thread(readTask, "Reader-" + i).start();
        }
    }
}
