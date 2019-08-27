/**
 * Author:Sophie
 * Created: 2019/8/24
 */

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class uniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
    public static int uniquePaths(int m,int n){
        int[][] Fi=new int[m][n];
        for (int i=0;i<n;i++){
            Fi[0][i]=1;
        }
        for (int i=0;i<m;i++){
            Fi[i][0]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                Fi[i][j]=Fi[i-1][j]+Fi[i][j-1];
            }
        }
        return Fi[m-1][n-1];
    }
}
