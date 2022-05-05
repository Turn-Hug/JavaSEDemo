package day02;

import java.util.concurrent.locks.ReentrantLock;

/*
    解决线程安全的方式三：Lock锁
 */
public class LockTest {
    public static void main(String[] args) {
        Window4 window4 = new Window4();

        Thread t1 = new Thread(window4);
        Thread t2 = new Thread(window4);
        Thread t3 = new Thread(window4);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window4 implements Runnable{
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}