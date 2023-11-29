package _8_SerializeCustomObject;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\user\\Desktop\\SirmaAcademy\\Java\\_12_Streams_Generics\\file\\ser.txt";

        Shape shape = new Shape("green", 15.3, 12.4);

        PutObject.put(shape, path);

        Shape theShape = GetObject.get(path);

        System.out.println(theShape.toString());
    }
}
