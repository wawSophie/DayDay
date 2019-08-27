import java.util.Scanner;

/**
 * Author:Sophie
 * Created: 2019/8/25
 */
public class KS3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int count=in.nextInt();
        int len= (int) (Math.pow(2,count)-1);
        String[] arr=new String[len];
        arr[0]="down";
        for (int i=1;i<len;i++){

        }
        for (int i=len-1;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}
