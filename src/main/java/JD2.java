import java.util.Scanner;

/**
 * Author:Sophie
 * Created: 2019/8/24
 */

/**
 * 思路：如果当前字母的下一个字母相反，那么采用临时处理；
 * 如果相同，则采用大写锁定键
 */
public class JD2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long count=Integer.parseInt(in.nextLine());
        String str=in.nextLine();
        long result2=getResult(count,str);
        System.out.println(result2);
    }

    //
    private static long getResult(long count, String str) {
        char[] arr=str.toCharArray();
        long result=0;
        if (count==0){
            return 0;
        }
        for (int i=0;i<count-1;i++){
            if (Math.abs(arr[i+1]-arr[i])>=32) {
                result++;
            }
        }
        result+=count;
        return result;
    }
}
