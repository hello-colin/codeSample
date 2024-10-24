package hcl.mythread;

import java.util.concurrent.*;

public class MyThreadPool2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor executorService= (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

//        Future<String> future =executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//
//            }
//        },"success");


        executorService.execute(new Runnable() {
            private String name="1111";
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

            public String getName() {
                return name;
            }
        });



    }
}
