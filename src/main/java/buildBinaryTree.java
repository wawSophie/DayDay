/**
 * Author:Sophie
 * Created: 2019/8/26
 */

/**
 * 题目：根据给定的数组，建立二叉搜索树
 */

import java.util.Arrays;

/**
 * 思路：以第一个结点为根节点，依次遍历数组，建立二叉树
 * 如果当前值大于根节点的值，就去判断根节点的右节点是否为空，若为空，则将此节点建立为根节点的右节点；如果当前值小于根节点的值，就去判断根节点的左节点是否为空，若为空，则将此节点建立为根节点的左节点
 * 若不为空，则重复上述步骤，进行递归，直到节点为空，建立为对应的左右节点
 */
class TreeNode1 {
    public int data;
    public TreeNode1 left;
    public TreeNode1 right;


    public TreeNode1(int data) {
        this.data=data;
    }
}
public class buildBinaryTree {
    public static void main(String[] args) {
        int[] arr=new int[]{12,3,9,2,16,5,25,6,24};
        if (arr.length==0){
            return;
        }
        //建立根节点
        TreeNode1 root=new TreeNode1(arr[0]);
        buildBinaryTree(root,arr);
        print(root);
    }

    private static TreeNode1 buildBinaryTree(TreeNode1 root, int[] arr) {
        for (int i=1;i<arr.length;i++){
            build(root,arr[i]);
        }
        return root;
    }

    private static void build(TreeNode1 root, int kdata) {
        if (root!=null){
            int data=root.data;
            if (data>kdata){
                if (root.left==null){
                    root.left=new TreeNode1(kdata);
                }else {
                    build(root.left,kdata);
                }
            }else {
                if (root.right==null) {
                    root.right = new TreeNode1(kdata);
                }else {
                    build(root.right,kdata);
                }
            }
        }
    }
    public static void  print(TreeNode1 root){
        if (root==null){
            return;
        }
        System.out.print(root.data+",");
        print(root.left);
        print(root.right);
    }
}
