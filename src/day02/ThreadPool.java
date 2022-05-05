package day02;

import java.util.concurrent.*;

/*
    创建线程的方法四：使用线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1、提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //2、设置线程池的属性
//        System.out.println(service.getClass());查看该对象是由哪个类创建的
        service1.setCorePoolSize(15);
        service1.setMaximumPoolSize(20);
//        service1.setKeepAliveTime();

        //3、执行指定线程的操作，需要提供Callable接口或者Runnable接口实现类的对象
        service.execute(new NumberThread());//适用于Runnable接口
        Future sum = service.submit(new NumberThread1());//适用于Callable接口
        try {
            Object num = sum.get();
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //4、关闭线程池
        service.shutdown();
    }
}

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

class NumberThread1 implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}