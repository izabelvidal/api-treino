package com.izabel.api.treino.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.izabel.api.treino.domain.Person;
import com.izabel.api.treino.service.validation.PersonUpdate;

@PersonUpdate
public class PersonDto {

	private Long id;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres!")
	private String name;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Email(message="Email Inválido!")
	private String email;
	
	public PersonDto(){}

	public PersonDto(Person obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
}
