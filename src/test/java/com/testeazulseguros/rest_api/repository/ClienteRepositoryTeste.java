package com.testeazulseguros.rest_api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.testeazulseguros.rest_api.model.Cliente;
import com.testeazulseguros.rest_api.repositorio.ClienteRepository;

public class ClienteRepositoryTeste {

    private EntityManager entityManager;

    private ClienteRepository repository = new ClienteRepository();
    private EntityTransaction transaction;

    @BeforeEach
    public void beforeEach() throws Exception {
        this.entityManager = Persistence.createEntityManagerFactory("desafio_azul").createEntityManager();
        this.transaction = entityManager.getTransaction();
        transaction.begin();
        Field entityManager = repository.getClass().getDeclaredField("entityManager");
        entityManager.setAccessible(true);
        entityManager.set(repository, this.entityManager);
    }

    @AfterEach
    public void afterEach() {
        this.transaction.commit();
    }

    @Test
    public void Save() {

        final Cliente cliente = new Cliente("nome" , "nome@nome.com", "123456789", "123456789", "Rua teste");

        final Cliente saved = repository.add(cliente);
        assertNotNull(saved.getId());

    }

    @Test
    public void findById() {

        final Cliente cliente = new Cliente("nome" , "nome@nome.com", "123456789", "123456789", "Rua teste");

        this.entityManager.persist(cliente);

        final Cliente saved = this.repository.findById(cliente.getId());
        assertNotNull(saved);

        assertEquals(cliente, saved);

    }

    @Test
    public void NullValue() {
        final Cliente saved = this.repository.findById(1L);

        assertNull(saved);
    }

    @Test
    public void FoundByEmail() {

        final Cliente cliente = new Cliente("nome" , "nome@nome.com", "123456789","123456789", "Rua teste");

        this.entityManager.persist(cliente);

        final Cliente saved = this.repository.findByEmail(cliente.getEmail());
        assertNotNull(saved);

        assertEquals(cliente, saved);
    }

    @Test
    public void NotFoundByEmail() {
        final Cliente saved = this.repository.findByEmail("");
        assertNull(saved);
    }

}
