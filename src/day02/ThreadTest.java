package day02;
/*
    创建线程的方法一：继承Thread
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("t1");
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
        t2.setName("t2");
        System.out.println("-------------");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
