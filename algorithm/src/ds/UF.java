package ds;

/**
 * Union-Find算法
 *
 * @author zhaoxuyang
 */
public interface UF {

    int size();

    int find(int p);

    boolean connected(int p, int q);

    void union(int p, int q);

    default void validate(int p, int n) {
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("p>=0 && p<n");
        }
    }
}
