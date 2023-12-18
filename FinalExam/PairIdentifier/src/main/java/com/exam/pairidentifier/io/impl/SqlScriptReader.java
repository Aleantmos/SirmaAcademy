package com.exam.pairidentifier.io.impl;

import com.exam.pairidentifier.io.CustomReader;
import com.exam.pairidentifier.util.ReaderUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class SqlScriptReader implements CustomReader {
    public List<? extends Serializable> read(String file) {

        List<String> commands = null;
        StringBuilder sqlScript = new StringBuilder();

        try {
            BufferedReader bufferedReader = ReaderUtils.getBufferedReader(file);

            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.isBlank()) {
                    sqlScript.append(line)
                            .append(System.lineSeparator());
                }

                line = bufferedReader.readLine();
            }

            if (!sqlScript.isEmpty()) {
                commands = List.of(sqlScript.toString().split(";"));
            }
        } catch (IOException e) {
            //todo -> handle error
        }


        return commands;
    }
}
