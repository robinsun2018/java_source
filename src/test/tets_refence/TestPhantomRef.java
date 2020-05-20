package test.tets_refence;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestPhantomRef {
    public static void main(String[] args) {
        /**
         *若某个对象与虚引用关联，那么在任何时候都可能被JVM回收掉。虚引用不能单独使用，必须配合引用队列一起使用。
         */
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> ref = new PhantomReference<>("str", queue);
        System.out.println(ref.get());

    }
}
