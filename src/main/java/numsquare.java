/**
 * Author:Sophie
 * Created: 2019/8/26
 */

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
//leetcode-279-完全平方数
//由题知，要求得组成正整数i的完全平方数的和，那么完全平方数的第一个数字，一定是小于等于正整数i
//那么，设DP[i]为正整数i的组成个数和，都是由完全平方数组成的，那么可以转化为DP[i-j*j]的组成个数+1（j*j表示完全平方数），或者就是i的大小，即i个1.
public class numsquare {

        public static void main(String[] args) {
            System.out.println(numSquares(13));
        }
        public static int numSquares(int n) {
            int[] dp=new int[n+1];
            for(int i=1;i<=n;i++){
                dp[i]=i;
                for(int j=1; i-j*j>=0; j++){
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                }
            }
            return dp[n];
        }
    }


