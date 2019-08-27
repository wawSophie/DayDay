import java.util.Scanner;

/**
 * Author:Sophie
 * Created: 2019/8/19
 */

/**
 * 我的思路：这是个维数问题，从坐标就可以判断出来是第k个数
 * 怎么样确定y呢，从y的最后一位开始，如果k>当前位的最大值，则把result的当前位置为最大，否则，break
 * break的话，有两种情况，一种相等，一种大于，大于的时候，我们要对当前位和当前位的前一位进行遍历，直到k==temp
 */
public class STTest4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //x是几维，将其各维数的最大值保存下来
        int n1=in.nextInt();
        int[] arr1=new int[n1];
        int size1=1;
        for (int i=0;i<n1;i++){
            arr1[i]=in.nextInt();
            size1*=arr1[i];
        }
        //y是几维，将其各维数的最大值保存下来
        int n2=in.nextInt();
        int size2=1;
        int[] arr2=new int[n2];
        for (int i=0;i<n2;i++){
            arr2[i]=in.nextInt();
            size2*=arr2[i];
        }
        //将x保存下来，用k计算是第几个数
        int k=1;
        int[] x=new int[n1];
        for (int i=0;i<n1;i++){
            x[i]=in.nextInt();
            k*=(x[i]+1);
        }
        int count=0;
        int[] result=new int[arr2.length];
        for (int m=0;m<arr2.length;m++){
            for (int n=0;n<arr2[m];n++){
                count++;
                result[m]=n;
                if (count==k){
                    break;
                }
            }
        }

        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
