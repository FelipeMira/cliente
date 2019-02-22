package com.fiap.grupo.dois.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.fiap.grupo.dois.model.Cliente;

public interface ClienteRepository extends Repository<Cliente, String> {
	 
    void delete(Cliente deleted);
    
    List<Cliente> findAll();
 
    Optional<Cliente> findById(String id);
 
    Cliente save(Cliente saved);
}
