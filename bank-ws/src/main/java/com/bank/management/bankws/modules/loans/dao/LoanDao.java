package com.bank.management.bankws.modules.loans.dao;

import java.util.List;

import com.bank.management.bankws.modules.loans.beans.Loan;

public interface LoanDao {

	public List<Loan> returnAll();

	public Loan returnOne(int id);

	public Loan create(Loan loan);

	public void delete(int id);
}