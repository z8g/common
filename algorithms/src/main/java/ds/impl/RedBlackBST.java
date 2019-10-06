package ds.impl;

import java.util.NoSuchElementException;

/**
 * 红黑树
 *
 * @author zhaoxuyang
 * @param <K>
 * @param <V>
 */
public class RedBlackBST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {

        private K key;
        private V value;
        private Node left;
        private Node right;
        private boolean isRed;
        private int size;

        public Node(K key, V value, boolean isRed, int size) {
            this.isRed = isRed;
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private boolean isRed(Node x) {
        return x == null ? false : x.isRed;
    }

    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
//        while (x != null) {
//            int cmp = key.compareTo(x.key);
//            if (cmp < 0) {
//                x = x.left;
//            } else if (cmp > 0) {
//                x = x.right;
//            } else {
//                return x.value;
//            }
//        }
//        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!containsKey(key)) {
            return;
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.isRed = true;
        }
        root = delete(root, key);
        if (!isEmpty()) {
            root.isRed = false;
        }
    }

    private Node delete(Node x, K key) {
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            if (!isRed(x.left) && !isRed(x.left.left)) {
                x = moveRedLeft(x);
            }
            x.left = delete(x.left, key);
        } else {
            if (isRed(x.left)) {
                x = rotateRight(x);
            }
            if (key.compareTo(x.key) == 0 && x.right == null) {
                return null;
            }
            if (!isRed(x.right) && !isRed(x.right.left)) {
                x = moveRedRight(x);
            }
            if (key.compareTo(x.key) == 0) {
                Node rightMinNode = min();
                x.key = rightMinNode.key;
                x.value = rightMinNode.value;
                x.right = deleteMin(x.right);
            } else {
                x.right = delete(x.right, key);
            }
        }
        return balance(x);
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        root.isRed = false;
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, true, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        } else if (isRed(x.left) && !isRed(x.right)) {
            x = rotateRight(x);
        } else if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    private Node rotateLeft(Node x) {
        Node result = x.right;
        x.right = result.left;
        result.left = x;
        result.isRed = result.left.isRed;
        result.left.isRed = true;
        result.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;
        return result;
    }

    private Node rotateRight(Node x) {
        Node result = x.left;
        x.left = result.right;
        result.right = x;
        result.isRed = result.right.isRed;
        result.right.isRed = true;
        result.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;
        return result;
    }

    private void flipColors(Node x) {
        x.isRed = !x.isRed;
        x.left.isRed = !x.left.isRed;
        x.right.isRed = !x.right.isRed;
    }

    private Node moveRedLeft(Node x) {
        flipColors(x);
        if (isRed(x.right.left)) {
            x.right = rotateRight(x.right);
            x = rotateLeft(x);
            flipColors(x);
        }
        return x;
    }

    private Node moveRedRight(Node x) {
        flipColors(x);
        if (isRed(x.left.left)) {
            x = rotateRight(x);
            flipColors(x);
        }
        return x;
    }

    private Node min() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Node deleteMin(Node right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Node balance(Node x) {
        if (isRed(x.right)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + mathMax(height(x.left), height(x.right));
    }

    private int mathMax(int a, int b) {
        return a > b ? a : b;
    }

    public K minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return minKey(root).key;
    }

    private Node minKey(Node x) {
        return x.left == null ? x : minKey(x.left);
    }

    public K maxKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return maxKey(root).key;
    }

    private Node maxKey(Node x) {
        return x.right == null ? x : maxKey(x.right);
    }

    public Iterable<K> keys() {
        if (isEmpty()) {
            return new LinkedQueue<K>();
        }
        return keys(minKey(), maxKey());
    }

    public Iterable<K> keys(K lo, K hi) {
        if (lo == null) {
            throw new IllegalArgumentException("first argument to keys() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("second argument to keys() is null");
        }

        LinkedQueue<K> queue = new LinkedQueue<>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, LinkedQueue<K> queue, K lo, K hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> st = new RedBlackBST<>();

        for (int i = 0; i < 100000; i++) {
            String key = "key" + i;
            Integer value = (int) (Math.random() * 10000);
            st.put(key, value);
        }
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println();
    }
}
