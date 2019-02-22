package com.fiap.grupo.dois.service;

import java.util.List;

import com.fiap.grupo.dois.dto.ClienteDTO;

public interface ClienteService {
	
	ClienteDTO create(ClienteDTO cliente);

    ClienteDTO delete(String id);
 
    List<ClienteDTO> findAll();

    ClienteDTO findById(String id);

    ClienteDTO update(ClienteDTO cliente);
}
