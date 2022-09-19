package com.bank.management.bankws.modules.clients.dao;

import java.util.List;

import com.bank.management.bankws.modules.clients.beans.Client;

public interface ClientDao {

	public List<Client> returnAll();

	public Client returnOne(int id);

	public Client create(Client client);

	public void delete(int id);
}