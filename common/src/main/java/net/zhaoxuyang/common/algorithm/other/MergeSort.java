package net.zhaoxuyang.common.algorithm.other;


import java.util.Arrays;

/**
 * 归并排序，时间复杂度O(nlog(n))，空间复杂度O(n)
 * @author zhaoxuyang
 */
public class MergeSort {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,7,5,1,2,0};
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
        System.out.println(Arrays.toString(tmp));
    }

    private static void mergeSort(int[] input, int low, int high, int[] output) {
        if(low < high){
            int middle = (low+high) /2;
            mergeSort(input,low,middle,output);
            mergeSort(input,middle+1,high,output);
            merge(input,low,middle,high,output);
        }
    }

    private static void merge(int[] input, int low, int high, int middle, int[] output) {
        int i =0;
        int j=low;
        int k=middle + 1;
        while(j<=middle && k<=high){
            if(input[j]<input[k]){
                output[i++] = input[j++];
            }else{
                output[i++]=input[k++];
            }
        }
        while(j<=middle){
            output[i++] = input[j++];
        }
        while(k<=high){
            output[i++] = input[k++];
        }
        for(int t = 0;t<i;t++){
            input[low+t] = output[t];
        }
    }

   
}
