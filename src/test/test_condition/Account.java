package test.test_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private final Lock lock= new ReentrantLock();
    private final Condition depositCond = lock.newCondition();
    private final Condition withdrawCond = lock.newCondition();

    private float balance;

    public Account(float balance) {
        this.balance = balance;
    }

    public void deposit(float num){
        lock.lock();
        try {
            while(balance >1000f){
                System.out.println("存钱阻塞");
                depositCond.await();
            }
            balance += num;
            System.out.println(Thread.currentThread().getName()+"存入："+num+"￥,余额为："+ balance);
            withdrawCond.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void withdraw(float num){
        lock.lock();
        try {
            while(num > balance ){
                System.out.println("取钱阻塞");
                withdrawCond.await();
            }
            balance -= num;
            System.out.println(Thread.currentThread().getName()+"取出："+num+"￥,余额为："+ balance);
            depositCond.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
