package test.test_lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t正在写入" + key);
            //暂停一下，模拟一下网络拥堵
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t正在读取");
            //暂停一下，模拟一下网络拥堵
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成" + result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }
    }
    public void clear(){
        map.clear();
    }

}
