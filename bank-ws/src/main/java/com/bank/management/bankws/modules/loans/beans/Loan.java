package com.bank.management.bankws.modules.loans.beans;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class Loan {
	private Integer id;

	@Positive
	private Double value;

	public Loan(Integer id, @NotEmpty Double value) {
		super();
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", value=" + value + "]";
	}
}