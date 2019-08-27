/**
 * Author:Sophie
 * Created: 2019/8/20
 */
public class WY1 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        int length=arr.length;
        while (length!=1){
            for (int i=0;i<arr.length;i++){
                int j=0;
                while (j<3){
                    if (arr[i]!=0){
                        j++;
                    }
                    if (j==2){
                        arr[i]=0;
                        length-=1;
                    }
                }
            }
            for (int i=arr.length;i>=0;i--){
                int j=0;
                while (j<3){
                    if (arr[i]!=0){
                        j++;
                    }
                    if (j==2){
                        arr[i]=0;
                        length-=1;
                    }
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                System.out.println(i);
            }
        }
    }
}
