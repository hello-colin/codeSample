package hcl.mythread;

import sun.nio.ch.ThreadPool;

import java.util.Queue;
import java.util.concurrent.*;

public class MyThreadPoll {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        ExecutorService executorService1=new ThreadPoolExecutor(3,10,1000,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());






    }
}
