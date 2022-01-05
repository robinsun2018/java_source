package test.test_condition.alterantely_printing;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * https://www.cnblogs.com/yanyapan/p/12915130.html
 */
public class ConditionMethod {
    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] letters = "ABCDEF".toCharArray();

        Lock lock = new ReentrantLock();
        Condition t1 = lock.newCondition();
        Condition t2 = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (char nt: letters) {
                    System.out.println(nt);
                    t2.signal();
                    t1.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char nt: numbers) {
                    System.out.println(nt);
                    t1.signal();
                    t2.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2").start();

    }
}
