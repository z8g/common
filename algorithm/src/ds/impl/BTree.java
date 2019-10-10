package ds.impl;

import ds.Data;
import io.StdOut;

/**
 *
 * @author zhaoxuyang
 * @param <K>
 * @param <V>
 */
public class BTree<K extends Comparable<K>, V> implements Data {

    private static final int M = 4;
    private Node root;
    private int height;
    private int size;

    private static class Node {

        private int m;
        private final Entry[] children = new Entry[M];

        public Node(int k) {
            m = k;
        }
    }

    private static class Entry {

        private Comparable key;
        private final Object value;
        private Node next;

        public Entry(Comparable key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public BTree() {
        root = new Node(0);
    }

    @Override
    public int size() {
        return size;
    }

    public int height() {
        return height;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return search(root, key, height);
    }

    private V search(Node node, K key, int height) {
        Entry[] children = node.children;

        if (height == 0) {
            for (int i = 0; i < node.m; i++) {
                if (eq(key, children[i].key)) {
                    return (V) children[i].value;
                }
            }
        } else {
            for (int i = 0; i < node.m; i++) {
                if (i + 1 == node.m || less(key, children[i + 1].key)) {
                    return search(children[i].next, key, height - 1);
                }
            }
        }
        return null;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node u = insert(root, key, value, this.height);
        size++;
        if (u == null) {
            return;
        }

        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node node, K key, V value, int height) {
        int i;
        Entry entry = new Entry(key, value, null);
        if (height == 0) {
            for (i = 0; i < node.m; i++) {
                if (less(key, node.children[i].key)) {
                    break;
                }
            }
        } else {
            for (i = 0; i < node.m; i++) {
                if ((i + 1 == node.m) || less(key, node.children[i + 1].key)) {
                    Node next = node.children[i++].next;
                    Node u = insert(next, key, value, height - 1);
                    if (u == null) {
                        return null;
                    }
                    entry.key = u.children[0].key;
                    entry.next = u;
                    break;
                }
            }
        }
        for (int j = node.m; j > i; j--) {
            node.children[j] = node.children[j - 1];
        }
        node.children[i] = entry;
        node.m++;
        if (node.m < M) {
            return null;
        } else {
            return split(node);
        }
    }

    private Node split(Node node) {
        int m = M / 2;
        Node result = new Node(m);
        node.m = m;
        for (int j = 0; j < m; j++) {
            result.children[j] = node.children[m + j];
        }
        return result;
    }

    @Override
    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node node, int height, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = node.children;
        if (height == 0) {
            for (int j = 0; j < node.m; j++) {
                s.append(indent)
                        .append(children[j].key)
                        .append('=')
                        .append(children[j].value)
                        .append('\n');

            }
        } else {
            for (int j = 0; j < node.m; j++) {
                if (j > 0) {
                    s.append(indent)
                            .append('(')
                            .append(children[j].key)
                            .append(')')
                            .append('\n');
                }
                s.append(toString(children[j].next, height - 1, indent + "#"));
            }
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        BTree<String, String> st = new BTree<>();

        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.simpsons.com",     "209.052.165.60");
        st.put("www.apple.com",        "17.112.152.32");
        st.put("www.amazon.com",       "207.171.182.16");
        st.put("www.ebay.com",         "66.135.192.87");
        st.put("www.cnn.com",          "64.236.16.20");
        st.put("www.google.com",       "216.239.41.99");
        st.put("www.nytimes.com",      "199.239.136.200");
        st.put("www.microsoft.com",    "207.126.99.140");
        st.put("www.dell.com",         "143.166.224.230");
        st.put("www.slashdot.org",     "66.35.250.151");
        st.put("www.espn.com",         "199.181.135.201");
        st.put("www.weather.com",      "63.111.66.11");
        st.put("www.yahoo.com",        "216.109.118.65");


        StdOut.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        StdOut.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        StdOut.println("simpsons.com:      " + st.get("www.simpsons.com"));
        StdOut.println("apple.com:         " + st.get("www.apple.com"));
        StdOut.println("ebay.com:          " + st.get("www.ebay.com"));
        StdOut.println("dell.com:          " + st.get("www.dell.com"));
        StdOut.println();

        StdOut.println("size:    " + st.size());
        StdOut.println("height:  " + st.height());
        StdOut.println(st);
        StdOut.println();
    }
}
