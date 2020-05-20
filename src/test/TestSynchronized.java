package test;

public class TestSynchronized {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}
