package _9_JarOfT;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Jar<File> jarFile = new Jar<>();

        File file1 = new File("somePath");
        File file2 = new File("otherPath");

        jarFile.add(file1);
        jarFile.add(file2);

        jarFile.remove();

        System.out.println(jarFile.size());
    }
}
