import java.util.*;

/**
 * Author:Sophie
 * Created: 2019/8/25
 */
public class KS2 {
    public static void main(String[] args) {
//        char[] chars=new char[26];
//        for (int i=0;i<26;i++){
//            chars[i]= (char) ('a'+i);
//        }
        Map<Character,Integer> map=new TreeMap<Character, Integer>(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        Scanner in=new Scanner(System.in);
        char[] arr=in.nextLine().toCharArray();
        if (arr.length==0 ){
            return;
        }
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        int size=map.size();
        int count=0;
        for (Map.Entry<Character,Integer> m:map.entrySet()){
            count++;
            if (count!=size) {
                System.out.print(m.getKey() + ":" + m.getValue() + ",");
            }else {
                System.out.print(m.getKey() + ":" + m.getValue());
            }

        }
//        for (int i=0;i<26;i++){
//            if (map.containsKey(chars[i])){
//                System.out.print(chars[i]+":"+map.get(chars[i])+",");
//            }
//        }
    }
}
