import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2_WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\file.txt";
        String outputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (FileInputStream input = new FileInputStream(inputPath);
            FileOutputStream out = new FileOutputStream(outputPath)) {

            int aByte = 0;
            while ((aByte = input.read()) >= 0) {
                if (!symbols.contains((char) aByte)) {
                    out.write(aByte);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
