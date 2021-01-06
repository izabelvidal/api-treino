package com.izabel.api.treino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izabel.api.treino.domain.Address;
import com.izabel.api.treino.domain.Person;
import com.izabel.api.treino.dto.PersonNewDto;
import com.izabel.api.treino.repository.AddressRepository;
import com.izabel.api.treino.repository.PersonRepository;
import com.izabel.api.treino.service.exception.ObjectNotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	public Person insert(PersonNewDto objDto) {
		Person obj = fromDto(objDto);
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
	
	public Person fromDto(PersonNewDto objDto) {
		Person obj = new Person(null, objDto.getName(), objDto.getEmail());
		Address address = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getDistrict(), objDto.getZipCode(), objDto.getCity(), objDto.getState(), obj);
		obj.getAddresses().add(address);
		return obj;
	}
}
