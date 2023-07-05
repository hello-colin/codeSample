package hcl.mythread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
信号量
 */
public class MySemaphore {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"准备进入停车场");
                        semaphore.acquire(1);
                        System.out.println(Thread.currentThread().getName()+"进入了停车场,停车5s");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        System.out.println(Thread.currentThread().getName()+"开始驶离停车场");
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName()+"驶离了停车场");
                    }

                }
            },"第"+i+"号汽车").start();
        }



    }
}
