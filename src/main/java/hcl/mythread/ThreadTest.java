package hcl.mythread;

public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" run");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadTest=new ThreadTest();
        threadTest.wait();
        threadTest.start();
    }
}
