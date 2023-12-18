package com.exam.pairidentifier.io;

import java.io.Serializable;
import java.util.List;

public interface CustomReader {
    List<? extends Serializable> read(String file);
}
