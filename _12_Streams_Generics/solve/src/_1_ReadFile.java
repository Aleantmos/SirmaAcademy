import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class _1_ReadFile {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\file.txt";

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int aByte = fileInputStream.read();

            while (aByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(aByte));
                aByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
