import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _7_NestedFoldersRec {

    public static void main(String[] args) {
        String startingPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\";

        File root = new File(startingPath);
        List<String> fileNames = new ArrayList<>();

        int cnt = recursion(root, fileNames);

        System.out.println(cnt);
        for (String dirName : fileNames) {
            System.out.print(dirName + " ");
        }
    }



    private static int recursion(File file,
                                  List<String> fileNames) {
        int cnt = 0;
        if (file.isDirectory()) {
            fileNames.add(file.getName());
            cnt++;
            File[] files = file.listFiles();
            for (File curr : files) {
                cnt += recursion(curr, fileNames);
            }
        }
        return cnt;
    }
}
