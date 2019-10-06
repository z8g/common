package ds.impl;

/**
 * 有向图
 *
 * @author zhaoxuyang
 */
public class Digraph {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private LinkedBag<Integer>[] adj;
    private int[] indegree;

    public Digraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException();
        }
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (LinkedBag<Integer>[]) new LinkedBag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedBag<>();
        }
    }

    public Digraph(Digraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < V; v++) {
            this.indegree[v] = G.indegree[v];
        }
        for (int v = 0; v < G.V(); v++) {
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
        adj[v1].add(v2);
        indegree[v2]++;
        E++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    public Digraph reverse() {
        Digraph result = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                result.addEdge(w, v);
            }
        }
        return result;
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
        Digraph g = new Digraph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
    }
}
