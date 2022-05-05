package day02;
/*
    解决线程安全问题的方法：
        方法一：同步代码块
            synchronized(同步监视器){
                需要被同步的代码
            }
            //操作共享数据的代码，即为需要被同步的代码
            //同步监视器，俗称 锁。任何一个类的对象都可以。
            要求：多个线程必须用同一把锁
        方法二：同步方法
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票：票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}