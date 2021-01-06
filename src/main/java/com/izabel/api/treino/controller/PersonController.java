package com.izabel.api.treino.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.izabel.api.treino.domain.Person;
import com.izabel.api.treino.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Person obj){
		personService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> obj = personService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> findByid(@PathVariable Long id){
		return ResponseEntity.ok().body(personService.find(id));
	}
	
}
