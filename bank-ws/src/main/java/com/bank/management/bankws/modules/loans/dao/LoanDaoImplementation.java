package com.bank.management.bankws.modules.loans.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.bank.management.bankws.modules.loans.beans.Loan;

@Component
public class LoanDaoImplementation implements LoanDao {

	private static List<Loan> loans = new ArrayList<>();

	private static int idCounter = 0;

	static {
		loans.add(new Loan(++idCounter, 20000.00));
	}

	@Override
	public List<Loan> returnAll() {
		return loans;
	}

	@Override
	public Loan returnOne(int id) {
		Predicate<? super Loan> predicate = loan -> loan.getId().equals(id);
		return loans.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public Loan create(Loan loan) {
		loan.setId(++idCounter);
		loans.add(loan);
		return loan;
	}

	@Override
	public void delete(int id) {
		Predicate<? super Loan> predicate = loan -> loan.getId().equals(id);
		loans.removeIf(predicate);
	}
}