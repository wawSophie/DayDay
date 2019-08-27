/**
 * Author:Sophie
 * Created: 2019/8/20
 */


/**
 * 来回顾一下二分查找
 * 算法思想比较简单，也就是，首先这个数组是一个升序数组，然后确定一个元素的位置，不在则返回-1；
 * 首先和中间值进行比较，如果小于，则进入到左区间，和左区间的中间值值进行比较；如果大于，则进入到右区间，和右区间的中间值值进行比较，重复上述步骤
 */
public class EFSelect {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,5,19,34,57};
        int key=19;
//        System.out.println(nrselect(arr,key));
        select(arr,key,0,arr.length-1);
    }

    /**
     * 递归的二分查找
     */
    private static void select(int[] arr,int key,int start,int end) {
        int mid = (start + end) / 2;
        if (start >end || key<arr[start] || key>arr[end]) {
            System.out.println(-1);
            return;
        }
        if (arr[mid] > key) {
            end = mid - 1;
            select(arr, key, start, end);
        } else {
            if (arr[mid] < key) {
                start = mid + 1;
                select(arr, key, start, end);
            }else {
                System.out.println(mid);
            }
        }
    }
    /**
     * 非递归的二分查找
     * @param arr
     * @param key
     * @return
     */
    private static int nrselect(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <=end) {
            mid = (start + end) / 2;
            if (arr[mid] > key) {
                end = mid - 1;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            }
            if (arr[mid] == key) {
                break;
            }
        }
        if (arr[mid] == key) {
            return mid;
        } else {
            return -1;
        }
    }
}
