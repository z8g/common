package ds.util;

import ds.impl.Digraph;
import ds.impl.LinkedQueue;

/**
 *
 * @author zhaoxuyang
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private int[] pre;
    private int[] post;
    private LinkedQueue<Integer> preorder;
    private LinkedQueue<Integer> postorder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
        pre = new int[G.V()];
        post = new int[G.V()];
        postorder = new LinkedQueue<>();
        preorder = new LinkedQueue<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        postorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }
}
