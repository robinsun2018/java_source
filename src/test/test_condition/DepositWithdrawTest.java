package test.test_condition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DepositWithdrawTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),
                Executors.defaultThreadFactory()
        );

        for (int i = 0; i < 5; i++) {
            Account acc = new Account(1000f);
            threadPoolExecutor.execute(new DepositThread(acc,100*i));
            threadPoolExecutor.execute(new WithdrawThread(acc,100*i));
        }
    }
}
