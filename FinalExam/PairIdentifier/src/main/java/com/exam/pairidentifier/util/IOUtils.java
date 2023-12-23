package com.exam.pairidentifier.util;

import java.io.*;

public class IOUtils {

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static BufferedReader getBufferedFileReader(String filePath) {
        try {
            return new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedReader getBufferedInputStreamReader(InputStream inputStream) {
        if (bufferedReader == null) {
            return new BufferedReader(new InputStreamReader(inputStream));
        }
        return bufferedReader;
    }


    public static BufferedWriter getBufferedFileWriter(File file) {
        try {
            if (bufferedWriter == null) {
                return new BufferedWriter(new FileWriter(file));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bufferedWriter;
    }


}
