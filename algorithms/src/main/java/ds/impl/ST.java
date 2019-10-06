package ds.impl;

import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 *
 * @author zhaoxuyang
 * @param <K>
 * @param <V>
 */
public class ST<K extends Comparable<K>,V> {
    private TreeMap<K,V> st;
    public ST(){
        st = new TreeMap<>();
    }
    public V get(K key){
        if(key==null){
            throw new IllegalArgumentException();
        }
        return st.get(key);
    }
    
    public void put(K key,V value){
        if(key==null){
            throw new IllegalArgumentException();
        }
        if(value==null){
            st.remove(key);
        }else{
            st.put(key, value);
        }
    }
    
    public void delete(K key){
        if(key==null){
            throw new  IllegalArgumentException();
        }
        
        st.remove(key);
    }
    
    public boolean contains(K key){
        if(key==null){
            throw new  IllegalArgumentException();
        }
        return st.containsKey(key);
    }
    
    public int size (){
        return st.size();
    }
    public  boolean isEmpty(){
        return size()==0;
    }
    public Iterable<K> keys(){
        return st.keySet();
    }
    
    public K min(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return st.firstKey();
    }
    
    public K max(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return st.lastKey();
    }
    public K ceiling(K key){
        if(key==null){
            throw new IllegalArgumentException();
        }
        K result =  st.ceilingKey(key);
        if(result==null){
            throw new NoSuchElementException();
        }
        return result;
    }
    
    public K floor(K key){
         if(key==null){
            throw new IllegalArgumentException();
        }
        K result =  st.floorKey(key);
        if(result==null){
            throw new NoSuchElementException();
        }
        return result;
    }
    
     public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        for (int i = 0; i< 100; i++) {
            st.put("key"+i, i);
        }
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}
