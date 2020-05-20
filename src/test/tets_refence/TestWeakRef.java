package test.tets_refence;

import java.lang.ref.WeakReference;

public class TestWeakRef {
    public static void main(String[] args) {
        /**
         *如果某个对象与弱引用关联，那么当JVM在进行垃圾回收时，无论内存是否充足，都会回收此类对象。
         */
        WeakReference<String> ref = new WeakReference<String>(new String("ser"));
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());

    }
}
