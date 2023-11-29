import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class _5_ListFiles {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\";

        //FileInputStream input = new FileInputStream(inputPath);

        File file = new File(inputPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File aFile : files) {
                if (!aFile.isDirectory()) {
                    String name = aFile.getName();
                    long size = aFile.length();
                    System.out.printf("%s: [%s]%n",
                            name, size);
                }
            }
        }
    }
}
