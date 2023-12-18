package com.exam.pairidentifier.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReaderUtils {

    private static BufferedReader bufferedReader;

    public static BufferedReader getBufferedReader(String filepath) {
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
