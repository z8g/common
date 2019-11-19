/**
 * 蚁群算法.
 * <pre>
 * 蚂蚁数量为m，
 * 所有城市之间的信息素用矩阵pheromone表示
 * 最短路径为bestLength，
 * 最佳路径为bestTour
 *
 * 蚂蚁中有自己的内存，内存中有禁忌表(Tabu)来存储蚂蚁已访问过的城市，其后不再访问。
 * 用允许访问的城市表(Allowed)来存储还可以访问的城市
 * 用一个矩阵Delta来存储它在一个循环中给所经过路径留下的信息素
 * 还有一些控制参数
 * 该蚂蚁行走完全程的总成本或距离(tourLength)
 * 算法总共运行MAX_GEN次
 * 运行时间为t
 *
 * (1) 初始化
 * 设t = 1, 初始化bestLength为正无穷, bestTour为空，
 * Delta中的所有元素初始化为0，Tabu表清空，Allowed表加入所有城市节点
 * 随机选择蚂蚁的起始位置，在Tabu中加入起始节点，Allowed中去掉该起始节点
 *
 * (2) 为每只蚂蚁选择下一节点
 * 节点的选择通过概率(公式1)搜索到，
 * 每搜索到一个，就将该节点加入到Tabu中，并从Allowed中删除该节点。
 * 重复n-1次，直到所有城市都遍历过一次。
 * 遍历过所有所有节点后，将起始节点加入到Tabu中。此时Tabu表
 * </pre>
 */
package other.ant;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author zhaoxuyang
 */
public class Ant implements Cloneable {

    private List<Integer> tabu;//禁忌表
    private List<Integer> allowedCities;//允许搜索的城市表
    private float[][] delta;//信息素变化矩阵
    private int[][] distance;//距离矩阵

    private float alpha;
    private float beta;

    private int tourLength;//路径长度
    private int cityNum;//城市数量

    private int firstCity;//起始城市
    private int currentCity;//当前城市

    public Ant() {
        cityNum = 30;
        tourLength = 0;
    }

    public void init(int[][] distance, float a, float b) {
        alpha = a;
        beta = b;
        allowedCities = new LinkedList<>();
        tabu = new LinkedList<>();
        this.distance = distance;
        delta = new float[cityNum][cityNum];
        for (int i = 0; i < cityNum; i++) {
            allowedCities.add(i);
            for (int j = 0; j < cityNum; j++) {
                delta[i][j] = 0.f;
            }
        }
        Random random = new Random(System.currentTimeMillis());
        firstCity = random.nextInt(cityNum);
        allowedCities.remove(firstCity);
        tabu.add(firstCity);
        currentCity = firstCity;
    }

    public void selectNextCity(float[][] pheromone) {
        float[] p = new float[cityNum];
        float sum = 0.0f;

        //计算分母部分
        for (int cityId : allowedCities) {
            sum += Math.pow(pheromone[currentCity][cityId], alpha) * Math.pow(1.0 / distance[currentCity][cityId], beta);
        }

        //计算概率矩阵
        for (int i = 0; i < cityNum; i++) {
            boolean flag = false;
            for (int cityId : allowedCities) {
                if (i == cityId) {
                    p[i] = (float) (Math.pow(pheromone[currentCity][i], alpha) * Math.pow(1.0 / distance[currentCity][i], beta));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                p[i] = 0.f;
            }
        }

        //轮盘赌选择下一个城市
        Random random = new Random(System.currentTimeMillis());
        float selectP = random.nextFloat();
        Integer selectCity = 0;
        float sum1 = 0.f;
        for (int i = 0; i < cityNum; i++) {
            sum1 += p[i];
            if (sum1 >= selectP) {
                selectCity = i;
                break;
            }
        }
        
        // 从允许选择的城市中去除selectCity
        allowedCities.remove(selectCity);

    }

}
