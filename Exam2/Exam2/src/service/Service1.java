package service;

import dbOps.CustomReader;
import dbOps.CustomWriter;

public abstract class Service1 {

    private final CustomReader customReader;
    private final CustomWriter customWriter;


    public Service1(CustomReader customReader, CustomWriter customWriter) {
        this.customReader = customReader;
        this.customWriter = customWriter;
    }

    public CustomReader getCustomReader() {
        return customReader;
    }

    public CustomWriter getCustomWriter() {
        return customWriter;
    }



    public abstract void addEmployees();

    public abstract void editEmployee();

    public abstract void fireEmployee();

    public abstract void listEmployees();

    public abstract void exit();

    public abstract void searchBy();



}
