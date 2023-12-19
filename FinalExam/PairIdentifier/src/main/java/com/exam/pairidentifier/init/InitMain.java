package com.exam.pairidentifier.init;

import com.exam.pairidentifier.init.dateFormats.InitFormats;
import com.exam.pairidentifier.init.db.InitDB;
import com.exam.pairidentifier.services.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitMain implements CommandLineRunner {
    private final InitDB initDB;
    private final InitFormats initFormats;
    //todo only for testing delete afterward!!!
    private final FileService fileService;

    public InitMain(InitDB initDB, InitFormats initFormats, FileService fileService) {
        this.initDB = initDB;
        this.initFormats = initFormats;
        this.fileService = fileService;
    }

    @Override
    public void run(String... args) throws Exception {
        initDB.createDatabase();
        initFormats.populateFormatDB();
        fileService.processData();
    }
}
