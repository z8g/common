package ds.util;

import ds.impl.Digraph;
import ds.impl.LinkedStack;

/**
 *
 * @author zhaoxuyang
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private LinkedStack<Integer> cycle;
    
    public DirectedCycle(Digraph G){
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int v = 0;v<G.V();v++){
            if(!marked[v] && cycle == null){
                fds(G,v);
            }
        }
    }

    private void fds(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for(int w : G.adj(v)){
            if(cycle != null){
                return;
            }else if(!marked[w]){
                edgeTo[w] = v;
                fds(G,w);
            }else if(onStack[w]){
                cycle = new LinkedStack<>();
                for(int x = v;x!=w;x =edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    
    public boolean hasCycle(){
        return cycle != null;
    }
    
    public Iterable<Integer> cycle(){
        return cycle;
    }
    
    private boolean check(){
        if(hasCycle()){
            int first = -1,last = -1;
            for(int v :cycle){
                if(first == -1){
                    first = v;
                    last = v;
                }
            }
            if(first != last){
                System.out.println("first!=last");
                return false;
            }
        }
        return true;
    }
    
}