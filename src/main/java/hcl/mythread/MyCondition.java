package hcl.mythread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCondition {
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("等待");
                    condition.await();
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {

                }
            }
        });


        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("准备释放");
                    Thread.sleep(2000);
                    System.out.println("释放");
                    condition.signal();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());

                }finally {

                }
            }
        });


        thread.start();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();

    }
}
