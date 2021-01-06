package com.izabel.api.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.izabel.api.treino.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	@Transactional(readOnly = true)
	Person findByEmail(String email);
}
