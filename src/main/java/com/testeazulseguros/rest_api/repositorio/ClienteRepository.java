package com.testeazulseguros.rest_api.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sun.istack.NotNull;
import com.testeazulseguros.rest_api.model.Cliente;

import lombok.extern.java.Log;

@Service
public class ClienteRepository {

	@PersistenceContext 
	private EntityManager entityManager;

	public Cliente findById(@NotNull final Long id) {

		final Cliente cliente = this.entityManager.find(Cliente.class, id);

		return cliente;
	}

	public Cliente findByEmail(@NotNull String email) {

		var cliente = this.entityManager.createQuery("SELECT c FROM Cliente c where c.email = :email", Cliente.class)
				.setParameter("email", email).getSingleResult();
		return cliente;
	}

	public List<Cliente> findAll() {
		return this.entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.id", Cliente.class).getResultList();
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public Cliente add(@NotNull final Cliente cliente) {

		this.entityManager.persist(cliente);

		return cliente;
	}
}
