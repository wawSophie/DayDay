import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:Sophie
 * Created: 2019/8/19
 */

/**
 * 思路：遍历字符串数组，判断是否出现
 */
public class STTest3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int count1=in.nextInt();
        int count2=in.nextInt();
        String[] str=new String[count1];
        for (int i=0;i<count1;i++){
            str[i]=in.next();
        }
        for (int i=0;i<count2;i++){
            String temp=in.next();
            getResult(temp,str);
        }
    }

    private static void getResult(String temp, String[] str) {
        int count=0;
        for (int i=0;i<str.length;i++){
            if (CX(temp,str[i])){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean CX(String temp, String s) {
        if (temp.length()!=s.length()){
            return false;
        }
        char[] arr1=temp.toCharArray();
        char[] arr2=s.toCharArray();
        List<Character> list1=new LinkedList<Character>();
        List<Character> list2=new LinkedList<Character>();
        for (int i=0;i<arr1.length;i++){
            list1.add(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++){
            list2.add(arr2[i]);
        }
        for (Character c:list1){
            if (list2.contains(c)){
                list2.remove(c);
            }else {
                return false;
            }
        }
        return true;
    }
}
