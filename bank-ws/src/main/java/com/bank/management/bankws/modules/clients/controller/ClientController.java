package com.bank.management.bankws.modules.clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.bankws.modules.clients.beans.Client;
import com.bank.management.bankws.modules.clients.dao.ClientDaoImplementation;
import com.bank.management.bankws.modules.clients.exceptions.ClientNotFoundException;

import jakarta.validation.Valid;

@RestController
public class ClientController {

	@Autowired
	private ClientDaoImplementation dao;

	public ClientController(ClientDaoImplementation dao) {
		this.dao = dao;
	}

	@GetMapping("/clients")
	public List<Client> returnAllClients() {
		return dao.returnAll();
	}

	@GetMapping("/clients/{id}")
	public Client returnOneClient(@PathVariable int id) {
		Client client = dao.returnOne(id);

		if (client == null) {
			throw new ClientNotFoundException("id:" + id);
		}

		return client;
	}

	@PostMapping("/clients/create")
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
		dao.create(client);

		return ResponseEntity.created(null).build();
	}

	@DeleteMapping("/clients/delete/{id}")
	public void deleteClient(@PathVariable int id) {
		dao.delete(id);
	}
}