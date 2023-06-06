package hcl.mythread;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MyThreadCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello my thread callable";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadCallable myThreadCallable=new MyThreadCallable();
        ExecutorService executorService= Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures=new ArrayList<>();
        for(int i=0;i<5;i++){
            futures.add(executorService.submit(new MyThreadCallable()));
        }
        for(Future<String> fs:futures){
            if(fs.isDone()){
                System.out.println(fs.get());
            }else {
                System.out.println("future is not yet complete");
            }
        }


        FutureTask futureTask=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "haha";
            }
        });
        Thread thread=new Thread(futureTask);
        thread.start();
        while(!futureTask.isDone()){
            System.out.println("future is not done");
        }
        if(futureTask.isDone()){
            System.out.println(futureTask.get());
        }

    }
}
