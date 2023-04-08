package hcl.example.threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static class Student{
        private int age=1;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Student student=new Student();

        lock.lock();
        lock.unlock();
        student.notify();

    }

}
