package com.bank.management.bankws.modules.clients.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.bank.management.bankws.modules.clients.beans.Client;

@Component
public class ClientDaoImplementation implements ClientDao {

	private static List<Client> clients = new ArrayList<>();

	private static int idCounter = 0;

	static {
		clients.add(new Client(++idCounter, "João", "130.870.569-79", "(45)99968-8403"));
		clients.add(new Client(++idCounter, "Henrique", "069.134.459-12", "(45)98405-3785"));
	}

	@Override
	public List<Client> returnAll() {
		return clients;
	}

	@Override
	public Client returnOne(int id) {
		Predicate<? super Client> predicate = client -> client.getId().equals(id);
		return clients.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public Client create(Client client) {
		client.setId(++idCounter);
		clients.add(client);
		return client;
	}

	@Override
	public void delete(int id) {
		Predicate<? super Client> predicate = client -> client.getId().equals(id);
		clients.removeIf(predicate);
	}
}