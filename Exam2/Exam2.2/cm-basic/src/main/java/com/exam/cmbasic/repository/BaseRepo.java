package com.exam.cmbasic.repository;

import com.exam.cmbasic.models.Client;

import java.util.List;

public interface BaseRepo {
    void addClient(Client client);
    boolean editClient(int id, Client client);
    Client getClient(int id) throws Exception;
    List<Client> getAllClients();
    void removeClient(int id);

}

