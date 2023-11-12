package model.entity.managers;

import model.enums.CommandEnum;
import service.Service;

public abstract class Manager {

    protected final Service service;

    public Manager(Service service) {
        this.service = service;
    }

    public abstract void execute(String command);
}
