package test.lru;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LFUCache {

    private int cap;
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFreq;
    private TreeMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new TreeMap<>();
    }

    public int get(int key) {
        //判断容量是否合法，key是否存在
        if (cap == 0 ||
                !keyToVal.containsKey(key)) {
            //不存在直接返回-1
            return -1;
        }
        //存在就移动至最新
        incrFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        //判断容量是否合法，key是否存在
        if (cap == 0 ||
                keyToVal.containsKey(key)) {
            //存在就替换val
            keyToVal.put(key, value);
            incrFreq(key);
            return;
        }
        //不存在则新增
        //判断是否超出容量
        if (keyToVal.size() >= this.cap) {
            //先删除频率最低的  p.s freqToKeys默认升序的
            int lowestFreq = freqToKeys.keySet().iterator().next();
            LinkedHashSet<Integer> linkedHashSet = freqToKeys.get(lowestFreq);
            int oldestKey = linkedHashSet.iterator().next();
            linkedHashSet.remove(oldestKey);
            keyToVal.remove(oldestKey);
            keyToFreq.remove(oldestKey);
        }
        //新增一条
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
    }


    private void incrFreq(int key) {
        if (!keyToVal.containsKey(key)) return;
        //新增
        if (keyToFreq.get(key) == null) {
            keyToFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            return;
        }
        //修改
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;
        //处理keyToFreq
        keyToFreq.put(key, newFreq);

        //处理freqToKeys
        if (freqToKeys.get(oldFreq) != null) {
            freqToKeys.get(oldFreq).remove(key);
            //size ==0 则删除key
            if (freqToKeys.get(oldFreq).size() == 0) {
                freqToKeys.remove(oldFreq);
            }
        }
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);
    }


    public static void main(String[] args) {
        /**
         * 输入：
         * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
         * 输出：
         * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/lfu-cache
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        LFUCache obj = new LFUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println("obj.get(1) = " + obj.get(1));
        obj.put(3, 3);
        System.out.println("obj.get(2) = " + obj.get(2));
        System.out.println("obj.get(3) = " + obj.get(3));
        obj.put(4, 4);
        System.out.println("obj.get(1) = " + obj.get(1));
        System.out.println("obj.get(3) = " + obj.get(3));
        System.out.println("obj.get(4) = " + obj.get(4));


    }
}
