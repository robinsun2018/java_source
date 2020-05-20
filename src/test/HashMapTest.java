package test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key1","value1");
        String put = hashMap.put("key1", "value2");
        System.out.println("put:"+put);

        //HashEntry<String, String> first = new HashEntry<>(12, "key1", "value1", null);

        //HashEntry<String, String> second = new HashEntry<>(12, "key2", "value2", first);

    }



/*    static final class HashEntry<K,V> {
        final int hash;
        final K key;
        volatile V value;
        volatile HashEntry<K,V> next;

        HashEntry(int hash, K key, V value, HashEntry<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }*/
}
