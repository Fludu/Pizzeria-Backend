package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clientList = clientService.getAllClients();
        return ResponseEntity.ok(clientList);
    }

    @PostMapping()
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client createdClient = clientService.saveClient(client);
        return ResponseEntity.status(201).body(createdClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping()
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return ResponseEntity.ok(clientService.getClientById(client.getId()));
    }
}
