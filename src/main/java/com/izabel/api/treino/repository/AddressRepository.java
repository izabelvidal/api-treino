package com.izabel.api.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izabel.api.treino.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
