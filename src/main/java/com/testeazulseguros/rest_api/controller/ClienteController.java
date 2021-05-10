package com.testeazulseguros.rest_api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.istack.NotNull;
import com.testeazulseguros.rest_api.model.Cliente;
import com.testeazulseguros.rest_api.repositorio.ClienteRepository;


@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@GetMapping
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{email}"})
	public Cliente findByEmail(String email) {
		return repository.findByEmail(email);
	}


	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return repository.add(cliente);
	}

//	private Response createResponse(final Cliente cliente) {
//		if (cliente == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.status(Status.OK).entity(cliente).build();
//	}

}
