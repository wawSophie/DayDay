import java.util.Scanner;

/**
 * Author:Sophie
 * Created: 2019/8/25
 */
public class KS4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(",");
        String sour = arr[0];
        String targ = arr[1];
        System.out.println(getResult(sour,targ));
    }

    private static int getResult(String sour, String targ) {
        int size1 =sour.length();
        int size2 =targ.length();
        if (size1 == 0) {
            return size2;
        }
        if (size2 == 0) {
            return size1;
        }
        int[][] dis = new int[size1 + 1][size2 + 1];
        dis[0][0] = 0;
        for (int i = 0; i <= size2; i++) {
            dis[0][i] = i;
        }
        for (int i = 0; i <= size1; i++) {
            dis[i][0] = i;
        }
        for (int i = 1; i <= size1; i++) {
            char temp1 = sour.charAt(i - 1);
            for (int j = 1; j <= size2; j++) {
                char temp2 = targ.charAt(j - 1);
                if (temp1 == temp2) {
                    dis[i][j]=dis[i-1][j-1];
                } else {
//                    dis[i][j] = Math.min(dis[i - 1][j - 1] + N, Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1));
                    dis[i][j]=1+Math.min(dis[i-1][j-1],Math.min(dis[i - 1][j] + 1, dis[i][j - 1] + 1));
                }
            }
        }
        return dis[size1][size2];
    }
}
