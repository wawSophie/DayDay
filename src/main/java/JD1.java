import java.util.Scanner;

/**
 * Author:Sophie
 * Created: 2019/8/24
 */
public class JD1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long count= Long.parseLong(in.nextLine());
        String str=in.nextLine();
        String[] arr=str.split(" ");
        long[] a=new long[(int) count];
        for (int i=0;i<count;i++){
            a[i]=Long.parseLong(arr[i]);
        }
        System.out.println(getResult(count,a));
    }

    private static int getResult(long count, long[] a) {
        int result=0;
        for (int i=0;i<count-1;i++){
            if (a[i+1]>a[i]){
                result++;
            }
        }
        return result+1;
    }
}
