package net.zhaoxuyang.common.algorithm.other;


import java.util.Arrays;

/**
 *
 * @author zhaoxuyang
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {1,3,4,5,6,4,3,2,5,2,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int low, int high) {
        int p;
        if(low < high){
            p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j= high;
        int p = arr[low];
        while(i<j){
            while(i<j && arr[j] >= p ){
                j--;
            }
            if(i<j){
                swap(arr,i++,j);
            }
            while(i<j && arr[i] <= p){
                i++;
            }
            if(i<j){    
                swap(arr,i,j--);
            }
        }
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
