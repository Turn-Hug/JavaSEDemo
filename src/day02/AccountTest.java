package day02;

import java.util.concurrent.locks.ReentrantLock;

/*
    银行有一个账户。
    有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer customer = new Customer(acct);
        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);
        t1.setName("男人");
        t2.setName("女人");
        t1.start();
        t2.start();

    }
}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void saveMoney(double amt){
        if (amt > 0){
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--存钱成功，余额为：" + balance);
        }
    }
}

class Customer implements Runnable{

    private Account acct;
    private ReentrantLock lock = new ReentrantLock(true);
    public Customer(Account acct){
        this.acct = acct;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                acct.saveMoney(1000);
            }finally {
                lock.unlock();
            }
        }
    }
}