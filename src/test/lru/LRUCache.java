package test.lru;

import java.util.LinkedHashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    private int cap;

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        //判断是否存在
        if (!cache.containsKey(key)) {
            //不存在直接返回-1
            return -1;
        }
        //存在
        //移动至最新
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //存在
            cache.put(key, value);
            //移动至最新
            makeRecently(key);
            return;
        }
        //不存在则新增
        //判断是否超出容量
        if (cache.size() >= this.cap) {
            //超出容量先删除头部的
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        //未超出容量
        cache.put(key, value);
    }


    private void makeRecently(int key) {
        Integer value = cache.get(key);
        if (value == null) return;
        cache.remove(key);
        cache.put(key, value);
    }
}
