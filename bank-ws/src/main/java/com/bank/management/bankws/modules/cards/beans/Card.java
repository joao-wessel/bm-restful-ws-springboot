package com.bank.management.bankws.modules.cards.beans;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Card {
	private Integer id;

	@Size(min = 16)
	private String number;

	@Positive
	private Double limit;

	@Size(min = 8)
	private String password;

	public Card(Integer id, @Size(min = 16) String number, @NotEmpty Double limit, @Size(min = 8) String password) {
		super();
		this.id = id;
		this.number = number;
		this.limit = limit;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getLimit() {
		return limit;
	}

	public void setLimit(Double limit) {
		this.limit = limit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", number=" + number + ", limit=" + limit + ", password=" + password + "]";
	}
}