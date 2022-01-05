package test.test_condition.alterantely_printing;

public class SynchronizedMethod {
    public static void main(String[] args) {
        final Object object = new Object();
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (object){
                for(char c : a1){
                    System.out.println(c);
                    try{
                        object.notify();
                        object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                object.notify();//避免有线程未被唤醒
            }
        },"t1").start();

        new Thread(() -> {
            synchronized (object){
                for(char c : a2){
                    System.out.println(c);
                    try{
                        object.notify();
                        object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                object.notify();//避免有线程未被唤醒
            }
        },"t2").start();
    }
}
