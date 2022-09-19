package com.bank.management.bankws.modules.clients.beans;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Client {
	private Integer id;

	@NotEmpty
	private String name;

	@Size(min = 14)
	private String cpf;

	@Size(min = 14)
	private String phone;

	public Client(Integer id, @NotEmpty String name, @Size(min = 14) String cpf, @Size(min = 14) String phone) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", phone=" + phone + "]";
	}
}