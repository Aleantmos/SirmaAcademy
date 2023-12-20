package com.exam.pairidentifier.init.dateFormats;

import com.exam.pairidentifier.services.DateFormatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitFormats {
    private final DateFormatService formatService;
    //todo magic variables -> fix
    private final List<String> formats = List.of("yyyy-MM-dd",
            "MM/dd/yyyy",
            "dd-MM-yyyy"
            );

    public InitFormats(DateFormatService formatService) {
        this.formatService = formatService;
    }


    public void populateFormatDB() throws Exception {
        if (checkFormatsCount()) {
            formatService.saveFormats(formats);
        }
    }

    private boolean checkFormatsCount() {
        long count = formatService.getSupportedFormatsCount();
        return count == 0;
    }
}
