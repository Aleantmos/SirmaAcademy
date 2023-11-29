import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _6_NestedFolders {
    public static void main(String[] args) {
        String startingPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\";

        File root = new File(startingPath);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int cnt = 0;

        List<String> dirNames = new ArrayList<>();
        while (!dirs.isEmpty()) {
            File curr = dirs.poll();
            File[] files = curr.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                    cnt++;
                    dirNames.add(file.getName());
                }
            }
        }

        System.out.println(cnt);
        for (String dirName : dirNames) {
            System.out.print(dirName + " ");
        }

    }
}
