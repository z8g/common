package ds.impl;

/**
 * 无向图
 *
 * @author zhaoxuyang
 */
public class Graph {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private LinkedBag<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException();
        }
        this.V = V;
        this.E = 0;
        adj = (LinkedBag<Integer>[]) new LinkedBag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedBag<>();
        }
    }

    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < V; v++) {
            LinkedStack<Integer> reverse = new LinkedStack<>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException();
        }
    }

    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        E++;
        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("V=").append(V).append(", E=").append(E).append(NEW_LINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEW_LINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
    }
}
