package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory()
        );
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() ->{
                System.out.println("执行当前任务的线程为："+Thread.currentThread().getName());
                try{
                    Thread.sleep(2000);
                }catch (Exception e){

                }
            });
            System.out.println("我是任务："+i+"，我在执行。。。");
        }
        threadPoolExecutor.shutdown();
        System.out.println(threadPoolExecutor.isShutdown());
    }
}
