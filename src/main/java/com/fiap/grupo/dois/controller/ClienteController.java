package com.fiap.grupo.dois.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.grupo.dois.dto.ClienteDTO;
import com.fiap.grupo.dois.error.AlunoNotFoundException;
import com.fiap.grupo.dois.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	private final ClienteService service;
	 
    @Autowired
    ClienteController(ClienteService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ClienteDTO create(@RequestBody @Valid ClienteDTO clienteEntry) {
        return service.create(clienteEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ClienteDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<ClienteDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ClienteDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ClienteDTO update(@RequestBody @Valid ClienteDTO clienteEntry) {
        return service.update(clienteEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(AlunoNotFoundException ex) {
    }
}
