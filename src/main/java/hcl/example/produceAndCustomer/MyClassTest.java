package hcl.example.produceAndCustomer;

import sun.misc.Unsafe;

public class MyClassTest {
    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    public static void main(String[] args) throws InterruptedException {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        Thread.sleep(2000);

        thread1.interrupt();
        Thread.sleep(5000);
        UNSAFE.unpark(thread1);
    }
}
