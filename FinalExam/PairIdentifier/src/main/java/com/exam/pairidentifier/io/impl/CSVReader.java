package com.exam.pairidentifier.io.impl;

import com.exam.pairidentifier.io.CustomReader;
import com.exam.pairidentifier.model.entity.Employee;
import com.exam.pairidentifier.model.entity.Project;
import com.exam.pairidentifier.util.ReaderUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CSVReader implements CustomReader {
    @Override
    public List<? extends Serializable> read(String fileName) {
        List<String> lines = new LinkedList<>();

        try (BufferedReader reader = ReaderUtils.getBufferedFileReader(fileName);) {
            String line = reader.readLine();

            while (line != null) {
                if (!line.isBlank()) {
                    lines.add(line);
                }

                line = reader.readLine();;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
