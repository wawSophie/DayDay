import java.util.Arrays;
import java.util.Stack;

/**
 * Author:Sophie
 * Created: 2019/8/20
 */

/**
 * 快排递归和非递归
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,23,9,24,65,1};
        int start=0;
        int end=arr.length-1;
//        quickSort(arr,start,end);
        nrquickSort(arr,start,end);
        System.out.println(Arrays.toString(arr));
    }

    private static void nrquickSort(int[] arr,int start,int end){
        Stack<Integer> stack=new Stack<Integer>();
        int par=partion(arr,start,end);
        if (par>start+1){
            stack.push(start);
            stack.push(par-1);
        }
        if (par<end-1){
            stack.push(par+1);
            stack.push(end);
        }
        while (!stack.isEmpty()){
            end=stack.pop();
            start =stack.pop();
            par=partion(arr,start,end);
            if (par>start+1){
                stack.push(start);
                stack.push(par-1);
            }
            if (par<end-1){
                stack.push(par+1);
                stack.push(end);
            }
        }
    }
    private static void quickSort(int[] arr,int start,int end) {
        int par=partion(arr,start,end);
        if (par>start+1){
            quickSort(arr,start,par-1);
        }
        if (par<end-1){
            quickSort(arr,par+1,end);
        }
        return;
    }

    private static int partion(int[] arr, int low, int high) {
        int temp=arr[low];
        while (low<high){
            while (temp<arr[high] && low<high){
                high--;
            }
            if (low>=high){
                break;
            }else {
                arr[low]=arr[high];
            }
            while (temp>arr[low] && low<high){
                low++;
            }
            if (low>=high){
                break;
            }else {
                arr[high]=arr[low];
            }
        }
        arr[high]=temp;
        return high;
    }
}


