package hcl.mythread;

import sun.nio.ch.ThreadPool;

import java.util.Queue;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class MyThreadPoll {
    public static void main(String[] args) throws InterruptedException {
        /*
        1.如果正在运行的线程数量小于corePoolSize，马上创建线程运行他
        2.如果正在运行的线程数大于corePoolSize，将任务放入队列中
        3.如果队列满了，正在运行线程数小于maximunPoolSize，创建非核心线程数运行他
        4.keepAliveTime，回收空闲超过时间的非核心线程
         */

        //队列无界，且线程数固定，如果任务过多会导致OOM
        //固定长度线程池
        ThreadPoolExecutor fixedExecutorService= (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        ExecutorService fixedExecutorService2= new ThreadPoolExecutor(2,2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        fixedExecutorService.allowCoreThreadTimeOut(true);



        //线程数量太多了，容易OOM
        //可缓存线程池
        ExecutorService cachedExecutorService=Executors.newCachedThreadPool();
        ExecutorService cachedExecutorService2=new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        //只有一个线程，容易OOM
        //单线程线程池
        ExecutorService singleExecutorService=Executors.newSingleThreadExecutor();
        ExecutorService singleExecutorService2= (new ThreadPoolExecutor(1, 1,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()));

        //延迟线程池
        //延迟队列实现
        ExecutorService scheduleExecutorService=Executors.newScheduledThreadPool(2);
//        ExecutorService scheduleExecutorService2=new ThreadPoolExecutor(2, Integer.MAX_VALUE, 0, NANOSECONDS,
//                new ScheduledThreadPoolExecutor.DelayedWorkQueue());

        //单线程延迟线程池
        ExecutorService singleScheduleExecutorService=Executors.newSingleThreadScheduledExecutor();

        //抢占式执行线程池
        ExecutorService workStealExecutorService=Executors.newWorkStealingPool();
        ExecutorService workStealExecutorService2=new ForkJoinPool
                (Runtime.getRuntime().availableProcessors(),
                        ForkJoinPool.defaultForkJoinWorkerThreadFactory,
                        null, true);




        ExecutorService executorService1=new ThreadPoolExecutor(3,10,1000,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());



        LinkedBlockingQueue<Integer>integerLinkedBlockingQueue=new LinkedBlockingQueue<>(1);
        integerLinkedBlockingQueue.put(Integer.valueOf(1));
        integerLinkedBlockingQueue.put(Integer.valueOf(2));
        integerLinkedBlockingQueue.put(Integer.valueOf(3));

        System.out.println(1);
    }
}
