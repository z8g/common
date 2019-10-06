package ds.impl;

import ds.Queue;

/**
 * 二叉查找树
 *
 * @author zhaoxuyang
 * @param <K>
 * @param <V>
 */
public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {

        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    public V get(K key) {
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
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public K minKey() {
        return minKey(root).key;
    }

    private Node minKey(Node x) {
        return x.left == null ? x : minKey(x.left);
    }

    public K maxKey() {
        return maxKey(root).key;
    }

    private Node maxKey(Node x) {
        return x.right == null ? x : maxKey(x.right);
    }

    public K floorKey(K key) {
        Node x = floorKey(root, key);
        return x == null ? null : x.key;
    }

    private Node floorKey(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floorKey(x, key);
        }
        Node t = floorKey(x.right, key);
        return t != null ? t : x;
    }

    public K ceilKey(K key) {
        Node x = ceilKey(root, key);
        return x == null ? null : x.key;
    }

    private Node ceilKey(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceilKey(x, key);
        }
        Node t = ceilKey(x.left, key);
        return t != null ? t : x;
    }

    public K selectKey(int k) {
        return selectKey(root, k).key;
    }

    private Node selectKey(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return selectKey(x.left, k);
        } else if (t < k) {
            return selectKey(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rankKey(K key) {
        return rankKey(root, key);
    }

    private int rankKey(Node x, K key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rankKey(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rankKey(x.right, key);
        } else {
            return size(x.left);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = minKey(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<K> keys() {
        return keys(minKey(), maxKey());
    }

    private Iterable<K> keys(K lowKey, K highKey) {
        LinkedQueue<K> queue = new LinkedQueue<>();
        keys(root, queue, lowKey, highKey);
        return queue;
    }

    private void keys(Node x, Queue<K> queue, K lowKey, K highKey) {
        if (x == null) {
            return;
        }
        
        int cmpLow = lowKey.compareTo(x.key);
        int cmpHigh = highKey.compareTo(x.key);
        
        if (cmpLow < 0) {
            keys(x.left, queue, lowKey, highKey);
        }
        if (cmpLow <= 0 && cmpHigh >= 0) {
            queue.enqueue(x.key);
        }
        if (cmpHigh > 0) {
            keys(x.right, queue, lowKey, highKey);
        }
    }
}
