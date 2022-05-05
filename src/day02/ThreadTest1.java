package day02;
/*
    创建多线程的方式二：实现Runnable接口
        1、创建一个实现了Runnable接口的类
        2、实现类去实现Runnable中的抽象方法：run()
        3、创建实现类对象
        4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        5、通过Thread类对象调用start()
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        Thread t1 = new Thread(myThread01);
        t1.start();
        Thread t2 = new Thread(myThread01);
        t2.start();
    }



}


class MyThread01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}