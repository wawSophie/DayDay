/**
 * Author:Sophie
 * Created: 2019/8/20
 */

import java.util.Arrays;

/**
 * 归并排序的递归和非递归
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,56,1,8,3,5};
//        mergeSort(arr,0,arr.length-1);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array){
        for (int i=1;i<array.length;i*=2){
            merge(array,i);
        }
    }

    private static void merge(int[] array, int gap) {
        int[] tempArray=new int[array.length];
        int i=0;
        int s1=0; int e1=s1+gap-1;
        int s2=e1+1;int e2=s2+gap-1 <= array.length-1 ? s2+gap-1:array.length-1;
        //保证有两个数据段
        while (s2<=array.length-1){
            while (s1<=e1 && s2<=e2){
                if (array[s1]<=array[s2]){
                    tempArray[i++]=array[s1++];
                }else {
                    tempArray[i++]=array[s2++];
                }
            }
            while (s1<=e1) {
                tempArray[i++]=array[s1++];
            }
            while (s2<=e2) {
                tempArray[i++]=array[s2++];
            }

            s1=e2+1;
            e1=s1+gap-1;
            s2=e1+1;
            e2=s2+gap-1 <= array.length-1 ?s2+gap-1:array.length-1;

        }
        while (s1 < array.length){
            tempArray[i++]=array[s1++];
        }

        //拷贝数据到原始数组
        for (int j=0;j<tempArray.length;j++){
            array[j]=tempArray[j];
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low>=high){
            return;
        }
        int mid=(high-low)/2+low;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        meger(arr,low,mid,high);
    }

    private static void meger(int[] arr, int low, int mid, int high) {
        int[] temp=new int[arr.length];
        int tempindex=low;
        int i =low;
        int s2=mid+1;
        while (low<=mid && s2<=high){
            if (arr[low]<arr[s2]){
                temp[tempindex++]=arr[low++];
            }else {
                temp[tempindex++]=arr[s2++];
            }
        }
        while (low<=mid){
            temp[tempindex++]=arr[low++];
        }
        while (s2<=high){
            temp[tempindex++]=arr[s2++];
        }

        while (i<=high){
            arr[i]=temp[i];
            i++;
        }
    }
}
