package hcl.mythread;

import java.util.concurrent.CompletableFuture;

public class MyCompletableFuture {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            int finalI = i;
            CompletableFuture<Object> future=CompletableFuture.supplyAsync(()->{
                try {
                    System.out.print(Thread.currentThread().getName()+" start"+ finalI);
                    Thread.sleep(60000);
                    System.out.print(Thread.currentThread().getName()+" end");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }).whenComplete((res,ex)->{

            });
        }
    }
}
