package com.izabel.api.treino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izabel.api.treino.domain.Person;
import com.izabel.api.treino.repository.AddressRepository;
import com.izabel.api.treino.repository.PersonRepository;
import com.izabel.api.treino.service.exception.ObjectNotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Person insert(Person obj) {
		obj.setId(null);
		obj = personRepository.save(obj);
		addressRepository.saveAll(obj.getAddresses());
		return obj;
	}
	
	public Person find(Long id) {
		Optional<Person> obj = personRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Person.class.getName()));
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
}
