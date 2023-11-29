package _8_SerializeCustomObject;

import java.io.*;

public class PutObject {
    public static void put(Shape shape, String path) {


        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(shape);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
