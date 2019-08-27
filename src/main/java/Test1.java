import java.util.*;
import java.util.stream.Stream;

public class Test1{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        Collections.addAll(list,1,2,1,1,1,3,4);
        Stream<Integer> stream=list.stream();
        System.out.println(stream.filter(
                (e)->e==1
        ).count());
    }
}