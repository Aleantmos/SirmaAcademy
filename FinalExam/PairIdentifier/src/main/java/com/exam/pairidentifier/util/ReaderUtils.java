package com.exam.pairidentifier.util;

import java.io.*;

public class ReaderUtils {

    private static BufferedReader bufferedReader;

    public static BufferedReader getBufferedFileReader(String filepath) {
        try {
            if (bufferedReader == null) {
                return new BufferedReader(new FileReader(filepath));
            }
        } catch (FileNotFoundException e) {
            //todo -> handle error
        }

        return bufferedReader;
    }



}
