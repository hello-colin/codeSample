package hcl.example.threadTest;

import java.security.PublicKey;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        String lock = "";
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    synchronized (lock) {
                        //sync获取monitor
                        System.out.println(Thread.currentThread().getName() + " 运行");
                        try {
                            System.out.println(Thread.currentThread().getName() + " 等待被唤醒");
                            lock.wait();
                            System.out.println(Thread.currentThread().getName() + " 被唤醒");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }.start();
        }
        Thread.sleep(1000);

//        synchronized (lock) {
//            System.out.println("主线程唤醒一个");
//            lock.notify();
//        }

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"主线程唤醒所有");
            lock.notifyAll();
        }
        System.out.println("运行结束");
        return;
    }
}
