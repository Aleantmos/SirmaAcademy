package com.exam.cmbasic.service;

import com.exam.cmbasic.models.Client;
import com.exam.cmbasic.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void addClient(Client client) {
        clientRepo.addClient(client);
    }

    public Client getClient(int id) throws Exception {
        return clientRepo.getClient(id);
    }

    public boolean editClient(int id, Client client) {
        return clientRepo.editClient(id, client);
    }

    public List<Client> getAllClients() {
        return clientRepo.getAllClients();
    }

    public void deleteClient(int id) {
        clientRepo.removeClient(id);
    }
}
