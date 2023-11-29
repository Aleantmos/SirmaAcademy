package _8_SerializeCustomObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetObject {
    public static Shape get(String path) {
        Shape shape = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            shape = (Shape) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return shape;
    }
}
