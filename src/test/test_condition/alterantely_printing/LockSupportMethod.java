package test.test_condition.alterantely_printing;

import java.util.concurrent.locks.LockSupport;
/**
 * https://www.cnblogs.com/yanyapan/p/12915130.html
 */
public class LockSupportMethod {

    private static Thread t1;

    private static Thread t2;

    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] letters = "ABCDEF".toCharArray();

        t1 = new Thread(() -> {
            for (char nt: letters) {
                System.out.println(nt);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(() -> {
            for (char nt: numbers) {
                LockSupport.park();
                System.out.println(nt);
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();

    }
}
