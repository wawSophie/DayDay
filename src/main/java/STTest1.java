/**
 * Author:Sophie
 * Created: 2019/8/19
 */

import java.util.Scanner;

/**
 *
 */
public class STTest1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] a=new int[N];
        int[] b=new int[N];
        int[] c=new int[N];
        for (int i=0;i<N;i++){
            a[i]=in.nextInt();
        }

        for (int i=0;i<N;i++){
            b[i]=in.nextInt();
        }
        for (int i=0;i<N;i++){
            c[i]=in.nextInt();
        }
        int sum=0;
        for (int i=0;i<b.length-1;i++){
            sum+=b[i];
        }
        sum+=a[a.length-1];
        System.out.println(sum);
    }
}
