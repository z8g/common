package net.zhaoxuyang.common.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 加工顺序
 * 先a后b的加工顺序，给定a和b各工件的耗时，求加工耗时最短的序列。
 * 解法：
 * 1. 求a中小于b的位置组g1：1,4,6；a中大于等于a的位置组g2：2,3,5,7
 * 2. 对g1非减序排序，对g2非增序排序
 * 3. 将g1连接上g2
 * @author zhaoxuyang
 */
public class ProcessingSquence {
    public static void main(String[] args) {
        int[] a = {3,8,10,12,6,9,15};
        int[] b = {7,2,6,18,3,10,4};
        
         List<Integer> result = flowShop(a,b);
         System.out.println(result);
    }

    private static List<Integer> flowShop(int[] a, int[] b) {
        int len = a.length;
        List<Integer> g1 = new ArrayList<>();
        List<Integer> g2 = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(a[i]<b[i]){
                g1.add(a[i]);
            }else{
                g2.add(b[i]);
            }
        }
        g1.sort((left,right)->{
            return left-right;
        });
        g2.sort((left,right)->{
            return right-left;
        });
        g1.addAll(g2);
        return g1;
    }
}
