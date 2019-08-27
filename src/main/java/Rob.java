/**
 * Author:Sophie
 * Created: 2019/8/24
 */


/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 */

/**
 * 思路：其实就是偶数层相加之和和奇数层相加之和取最大，使用递归，判断node是否为
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Rob {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root){
        return dorob(root);
    }
    public int dorob(TreeNode root) {
        if (root==null){
            return 0;
        }
        int jcount=root.val;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int ocount=dorob(left)+dorob(right);
        if (left!=null){
            jcount+=dorob(left.left);
            jcount+=dorob(left.right);
        }
        if (right!=null){
            jcount+=dorob(right.left);
            jcount+=dorob(right.right);
        }
        return Math.max(jcount,ocount);

    }
}

