package com.fiap.grupo.dois.mongoDb;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.grupo.dois.dto.ClienteDTO;
import com.fiap.grupo.dois.error.AlunoNotFoundException;
import com.fiap.grupo.dois.model.Cliente;
import com.fiap.grupo.dois.repository.ClienteRepository;
import com.fiap.grupo.dois.service.ClienteService;

@Service
public final class MongoDBClienteService implements ClienteService {
	
	private final ClienteRepository repository;
	 
    @Autowired
    MongoDBClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public ClienteDTO create(ClienteDTO cliente) {
        Cliente persisted = Cliente.getBuilder()
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public ClienteDTO delete(String id) {
        Cliente deleted = findClienteById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clienteEntries = repository.findAll();
        return convertToDTOs(clienteEntries);
    }
 
    private List<ClienteDTO> convertToDTOs(List<Cliente> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public ClienteDTO findById(String id) {
        Cliente found = findClienteById(id);
        return convertToDTO(found);
    }
 
    @Override
    public ClienteDTO update(ClienteDTO cliente) {
        Cliente updated = findClienteById(cliente.getId());
        updated.update(cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Cliente findClienteById(String id) {
        Optional<Cliente> result = repository.findById(id);
        return result.orElseThrow(() -> new AlunoNotFoundException(id));
 
    }
 
    private ClienteDTO convertToDTO(Cliente model) {
        ClienteDTO dto = new ClienteDTO();
 
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setTelefone(model.getTelefone());
 
        return dto;
    }
}
