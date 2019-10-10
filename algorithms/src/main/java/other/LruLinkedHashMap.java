package other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    public static void main(String[] args) {
        LruLinkedHashMap<Character, Integer> lruQueue = new LruLinkedHashMap(10);
        String data = "abcdefghijklmnfff";
        for (int i = 0; i < data.length(); i++) {
            lruQueue.put(data.charAt(i), i);
        }
        System.out.printf("k=f,value=%d\n", lruQueue.get('f'));
        System.out.printf("size()=%d\n", lruQueue.size());
        System.out.printf("lruQueue=%s\n", lruQueue);
        /*
         k=f,value=16
         size()=10
         lruQueue={e=4, g=6, h=7, i=8, j=9, k=10, l=11, m=12, n=13, f=16}
         */
    }

    private static final boolean ACCESS_ORDER = true;//开启按访问顺序排序的模式
    private static final float LOAD_FACTOR = 0.75f;
    private final Lock lock = new ReentrantLock();
    private final int initialCapacity;

    public LruLinkedHashMap(int initialCapacity) {
        super(initialCapacity, LOAD_FACTOR, ACCESS_ORDER);
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > initialCapacity;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<K, V>> getAll() {
        try {
            lock.lock();
            return new ArrayList<>(super.entrySet());
        } finally {
            lock.unlock();
        }
    }
}
