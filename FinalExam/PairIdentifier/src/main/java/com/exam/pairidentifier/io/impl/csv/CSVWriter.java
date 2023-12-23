package com.exam.pairidentifier.io.impl.csv;

import com.exam.pairidentifier.io.CustomWriter;
import com.exam.pairidentifier.util.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.exam.pairidentifier.util.MyConstants.ROUGH_FILE_CONTAINER_PATH;


public class CSVWriter implements CustomWriter {
    @Override
    public void write(MultipartFile multipartFile) {
        File destination = getFileDestination(multipartFile.getOriginalFilename());
        try (InputStream inputStream = getMultipartFileStream(multipartFile);
             BufferedReader receivedFileReader = IOUtils.getBufferedInputStreamReader(inputStream);
             BufferedWriter writer = IOUtils.getBufferedFileWriter(destination)) {

            String line = receivedFileReader.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = receivedFileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private File getFileDestination(String originalFilename) {
        Path path = Paths.get(ROUGH_FILE_CONTAINER_PATH, originalFilename);
        return path.toFile();
    }

    private InputStream getMultipartFileStream(MultipartFile multipartFile) {
        try {
            return multipartFile.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
