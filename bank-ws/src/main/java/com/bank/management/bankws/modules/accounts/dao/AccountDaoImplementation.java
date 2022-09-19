package com.bank.management.bankws.modules.accounts.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.bank.management.bankws.modules.accounts.beans.Account;

@Component
public class AccountDaoImplementation implements AccountDao {

	private static List<Account> accounts = new ArrayList<>();

	private static int idCounter = 0;

	static {
		accounts.add(new Account(++idCounter, "12345678-9", 6060, "Nu"));
	}

	@Override
	public List<Account> returnAll() {
		return accounts;
	}

	@Override
	public Account returnOne(int id) {
		Predicate<? super Account> predicate = account -> account.getId().equals(id);
		return accounts.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public Account create(Account account) {
		account.setId(++idCounter);
		accounts.add(account);
		return account;
	}

	@Override
	public void delete(int id) {
		Predicate<? super Account> predicate = account -> account.getId().equals(id);
		accounts.removeIf(predicate);
	}
}