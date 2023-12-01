package com.exam.cmbasic.controller;

import com.exam.cmbasic.models.Client;
import com.exam.cmbasic.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addClient(@RequestBody Client client) {

        clientService.addClient(client);
        return ResponseEntity.ok("Client added successfully!");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getClient(@PathVariable int id) {
        try {
            Client client = clientService.getClient(id);
            return ResponseEntity.ok(client.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editClient(@PathVariable int id, @RequestBody Client client) {
        boolean successful = clientService.editClient(id, client);
        if (successful) {
            return ResponseEntity.ok("Edit successful");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Edit not successful");
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllClients() {
        List<Client> allClients = clientService.getAllClients();

        StringBuilder result = new StringBuilder();

        for (Client client : allClients) {
            result.append(client.toString()).append(System.lineSeparator());
        }

        return ResponseEntity.ok().body(result.toString());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);

        return ResponseEntity.ok().body("Client deleted");
    }



}
