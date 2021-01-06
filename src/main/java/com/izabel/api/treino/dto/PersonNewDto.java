package com.izabel.api.treino.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class PersonNewDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres!")
	private String name;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Email(message="Email Inválido!")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	private String street;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	private String number;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	private String district;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	private String zipCode;
	private String city;
	private String state;
	
	public PersonNewDto() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
