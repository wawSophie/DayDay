/**
 * Author:Sophie
 * Created: 2019/8/27
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class twoSum {
    public static void main(String[] args) {
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if (map.containsKey(temp) && map.get(temp)>i){
                result[0]=i;
                result[1]=map.get(temp);
            }
        }
        return result;
    }
}
