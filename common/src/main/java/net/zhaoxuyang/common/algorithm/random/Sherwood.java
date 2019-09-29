package net.zhaoxuyang.common.algorithm.random;

import java.util.Arrays;
import net.zhaoxuyang.common.algorithm.other.QuickSort;
import net.zhaoxuyang.common.algorithm.other.Shuffle;

/**
 *
 * 舍伍德算法
 * @author zhaoxuyang
 */
public class Sherwood {
    
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,7,6};
        randomQuickSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 打乱顺序，再排序
     * @param array 
     */
    static void randomQuickSort(int[] array){
        Shuffle.shuffle(array);
        QuickSort.quickSort(array);
    }
}
