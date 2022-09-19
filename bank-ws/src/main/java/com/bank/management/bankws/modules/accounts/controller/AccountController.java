package com.bank.management.bankws.modules.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.bankws.modules.accounts.beans.Account;
import com.bank.management.bankws.modules.accounts.dao.AccountDaoImplementation;
import com.bank.management.bankws.modules.accounts.exceptions.AccountNotFoundException;

import jakarta.validation.Valid;

@RestController
public class AccountController {

	@Autowired
	private AccountDaoImplementation dao;

	public AccountController(AccountDaoImplementation dao) {
		this.dao = dao;
	}

	@GetMapping("/accounts")
	public List<Account> returnAllAccounts() {
		return dao.returnAll();
	}

	@GetMapping("/accounts/{id}")
	public Account returnOneAccount(@PathVariable int id) {
		Account account = dao.returnOne(id);

		if (account == null) {
			throw new AccountNotFoundException("id:" + id);
		}

		return account;
	}

	@PostMapping("/accounts/create")
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
		dao.create(account);

		return ResponseEntity.created(null).build();
	}

	@DeleteMapping("/accounts/delete/{id}")
	public void deleteAccount(@PathVariable int id) {
		dao.delete(id);
	}
}