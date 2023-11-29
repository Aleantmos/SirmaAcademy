import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _3_CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\file.txt";
        String outputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\p3.txt";

        try (FileInputStream input = new FileInputStream(inputPath);
             FileOutputStream output = new FileOutputStream(outputPath)) {

            int aByte = input.read();
            while (aByte >= 0) {
                if (aByte == 10 || aByte == 0) {
                    output.write((char) aByte);
                } else {
                    output.write(String.valueOf(aByte).getBytes());
                }
                aByte = input.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
