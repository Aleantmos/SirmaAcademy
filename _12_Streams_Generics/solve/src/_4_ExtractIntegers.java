import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _4_ExtractIntegers {
    public static void main(String[] args) {

        //todo

        String inputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\file.txt";
        String outputPath = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\p4.txt";

        String regex = "(?:[^\\w\\d]|^)(\\d+)(?=[^\\w\\d]|$)";
        List<String> numbers = new ArrayList<>();

        try {
            FileInputStream input = new FileInputStream(inputPath);
            FileOutputStream output = new FileOutputStream(outputPath);

            Pattern pattern = Pattern.compile(regex);

            List<Character> elements = new ArrayList<>();

            int aByte = input.read();
            while (aByte >= 0) {
                if (aByte != 10 && aByte != 32) {
                    elements.add(Character.valueOf((char) aByte));
                } else {
                    StringBuilder curr = new StringBuilder();
                    for (Character element : elements) {
                        curr.append(element.toString());
                    }

                    List<String> strings = checkMatch(pattern, curr.toString());

                    if (strings != null) {
                        String substring = strings.get(0);
                        output.write((substring + " ").getBytes());
                    }

                    elements.removeAll(elements);
                }

                aByte = input.read();
                ;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> checkMatch(Pattern pattern, String text) {
        List<String> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(text);
        }
        if (result.isEmpty()) {
            return null;
        }

        return result;
    }

}
