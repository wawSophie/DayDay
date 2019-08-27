import ConfigProperties.ConfigProperties;

import java.util.*;

/**
 * Author:Sophie
 * Created: 2019/8/25
 */
public class KS1 {
    public static void main(String[] args) {
        List<Character> list=new ArrayList<Character>();
        list.add('a');
        list.add('b');
        list.add('c');
//        ListIterator<Character> listIterator=list.listIterator();
//        Iterator<Character> l=list.iterator();
//        while (listIterator.hasPrevious()) {
//            System.out.println(listIterator.previous());
//        }

//        while (l.hasNext()) {
//            System.out.println(l.next());
//        }
//
//        Scanner in=new Scanner(System.in);
//        String str=in.nextLine();
//        String[] arr=str.split(";");
//        if (arr[0].length()==0 ||arr[0]==null){
//            System.out.println(arr[1]);
//            return;
//        }
//        List<Character> list=getResult(arr[0],arr[1]);
//        for (Character c:list){
//            System.out.print(c);
//        }
    }

    private static List getResult(String ch, String str) {
        List<Character> list=new ArrayList<Character>();
//        if(str.length()==0 || str==null){
//            return list;
//        }
        char[] chars=str.toCharArray();
        int temp=0;
        while (chars[temp]==ch.toCharArray()[0] && temp<chars.length){
            temp++;
        }
        for (int i=temp;i<chars.length;i++){
            if (chars[i]==ch.toCharArray()[0] && !list.isEmpty()){
                int index=list.size();
                list.remove(index-1);
            }else {
                list.add(chars[i]);
            }
        }
        return list;
    }
}
