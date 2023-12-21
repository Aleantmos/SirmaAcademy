package com.exam.pairidentifier.io;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public interface CustomWriter {
   void write(MultipartFile multipartFile);

}
