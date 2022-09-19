package com.bank.management.bankws.modules.accounts.beans;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Account {
	private Integer id;

	@Size(min = 10)
	private String number;

	@Digits(fraction = 0, integer = 4)
	private Integer agency;

	@NotEmpty
	private String bank;

	public Account(Integer id, @Size(min = 10) String number, @Size(min = 4) Integer agency, @NotEmpty String bank) {
		super();
		this.id = id;
		this.number = number;
		this.agency = agency;
		this.bank = bank;
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

	public Integer getAgency() {
		return agency;
	}

	public void setAgency(Integer agency) {
		this.agency = agency;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", agency=" + agency + ", bank=" + bank + "]";
	}
}