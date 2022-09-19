package com.bank.management.bankws.modules.accounts.dao;

import java.util.List;

import com.bank.management.bankws.modules.accounts.beans.Account;

public interface AccountDao {
	public List<Account> returnAll();

	public Account returnOne(int id);

	public Account create(Account account);

	public void delete(int id);
}