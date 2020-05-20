package test.tets_refence;

import java.lang.ref.SoftReference;

public class TestSoftRef {
    public static void main(String[] args) {
        /**
         * java中使用SoftRefence来表示软引用，如果某个对象与软引用关联，那么JVM只会在内存不足的情况下回收该对象。
         *
         * 那么利用这个特性，软引用可以用来做缓存。
         */
        SoftReference<String> ref = new SoftReference<String>("test");
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());
    }
}
