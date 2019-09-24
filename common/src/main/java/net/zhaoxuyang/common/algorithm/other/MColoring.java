/**
 * 图的m着色问题
 */
package net.zhaoxuyang.common.algorithm.other;

/**
 *
 * @author zhaoxuyang
 */
public class MColoring {
    
    public static void main(String[] args){
        int n = 5;
        int m =5;
        int[][] a={
            {-1,-1,-1,-1,-1,-1},
            {-1,0,1,1,1,0},
            {-1,1,0,1,1,1},
            {-1,1,1,0,1,0},
            {-1,1,1,1,0,1},
            {-1,0,1,0,1,0}
        };
        MColoring c =new MColoring();
        long sum = c.coloring(m, n, a);
        System.out.println(sum);

    }
    
    int n; // 图的顶点数
    int m; // 可用的颜色数
    int[][] a;//图的邻接矩阵
    int[] x;//当前解
    long sum;//当前已找到的可m着色方案数
    
    public long coloring(int m,int n,int[][]a){
        this.n = n;
        this.a = a;
        x = new int[n+1];
        this.m = m;
        sum = 0;
        backtrack(1);
        return sum;
    }

    private void backtrack(int t) {
        if(t > n){
            sum ++;
            for(int i=1;i<=n;i++){
                visit(x[i]);
            }
            System.out.println();
        }else {
            for(int i=1;i<=m;i++){
                x[t]=i;
                if(ok(t)){
                    backtrack(t+1);
                }
                x[t]=0;
            }
        }
    }

    private void visit(int item) {
        System.out.printf("%d ",item);
    }

    private boolean ok(int k) {
        for(int j=1;j<=n;j++){
            if(a[k][j]==1 && x[j]==x[k]){
                return false;
            }
        }
        return true;
    }
    
    
}
    