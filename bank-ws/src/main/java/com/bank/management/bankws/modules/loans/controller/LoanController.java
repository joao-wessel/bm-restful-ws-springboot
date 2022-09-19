package com.bank.management.bankws.modules.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.bankws.modules.loans.beans.Loan;
import com.bank.management.bankws.modules.loans.dao.LoanDaoImplementation;
import com.bank.management.bankws.modules.loans.exceptions.LoanNotFoundException;

import jakarta.validation.Valid;

@RestController
public class LoanController {

	@Autowired
	private LoanDaoImplementation dao;

	public LoanController(LoanDaoImplementation dao) {
		this.dao = dao;
	}

	@GetMapping("/loans")
	public List<Loan> returnAllLoans() {
		return dao.returnAll();
	}

	@GetMapping("/loans/{id}")
	public Loan returnOneClient(@PathVariable int id) {
		Loan loan = dao.returnOne(id);

		if (loan == null) {
			throw new LoanNotFoundException("id:" + id);
		}

		return loan;
	}

	@PostMapping("/loans/create")
	public ResponseEntity<Loan> createLoan(@Valid @RequestBody Loan loan) {
		dao.create(loan);

		return ResponseEntity.created(null).build();
	}

	@DeleteMapping("/loans/delete/{id}")
	public void deleteLoan(@PathVariable int id) {
		dao.delete(id);
	}
}