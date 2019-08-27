import java.io.File;
import java.io.InputStream;

/**
 * Author:Sophie
 * Created: 2019/8/20
 */
public class DFiles {
    public static void main(String[] args) {
        File file=new File("D:\\");
        for (File f:file.listFiles()){
            if (f.isDirectory()){
                for (File ff:f.listFiles()){
                    System.out.println(ff
                    );
                }
            }
            if (f.isFile()){
                System.out.println(f);
            }
        }
    }
}
