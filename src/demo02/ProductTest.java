package demo02;
/**
* @Description:经典案例：生产者/消费者问题
* @Author: Hequan
* @Version:
* @Date: 2022/4/27 17:52
*/
class Clerk{

    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        if (productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//生产者
class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品...");

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}
//消费者
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始消费产品...");

        while (true){
            try {
                Thread.sleep(24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread p1 = new Thread(producer);
        p1.setName("生产者1");
        Thread c1 = new Thread(consumer);
        c1.setName("消费者1");
        Thread c2 = new Thread(consumer);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();



    }
}
