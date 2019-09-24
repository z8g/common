package net.zhaoxuyang.common.algorithm.other;

/**
 * LRU算法：使用链表保存缓存数据
 * 1. 新数据插入到链表头部
 * 2. 每当缓存命中（即缓存数据被访问），则将数据移动到链表头部
 * 3. 当链表满的时候，将链表尾部的数据丢弃
 * 
 * 当存在热点数据时，效率很好，但偶发性的、周期性的批量操作会导致LRU命中率急剧下降，缓存污染严重。
 * 实现简单
 * 命中时需要遍历链表，找到命中的数据块索引，然后将数据移到头部。
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用一个链表保存缓存数据
 * @author zhaoxuyang
 * @param <K>
 * @param <V>
 */
public class LruLinkedHashMap<K,V> extends LinkedHashMap<K,V>{
    private final int MAX_CAPACITY;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final Lock lock = new ReentrantLock();
    
    public LruLinkedHashMap(int maxCapacity){
        super(maxCapacity,DEFAULT_LOAD_FACTOR,true);
        this.MAX_CAPACITY = maxCapacity;
    }
    
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K,V> eldest){
        return size() > this.MAX_CAPACITY;
    }
    
    @Override
    public boolean containsKey(Object key){
        try{
            lock.lock();
            return super.containsKey(key);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }finally{
            lock.unlock();
        }
    }
    
    @Override
    public V get(Object key){
        try{
            lock.lock();
            return super.get(key);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            lock.unlock();
        }
    }
    
    @Override
    public V put(K key, V value){
        try {
            lock.lock();
            return super.put(key, value);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            lock.unlock();
        }
    }
    
    @Override
    public int size(){
        try{
            lock.lock();
            return super.size();
        }finally{
            lock.unlock();
        }
    }
    @Override
    public void clear(){
        try{
            lock.lock();
            super.clear();
        }finally{
            lock.unlock();
        }
    }
    public Collection<Map.Entry<K,V>> getAll(){
        try{
            lock.lock();
            return new ArrayList<>(super.entrySet());
        }finally{
            lock.unlock();
        }
    }
}
