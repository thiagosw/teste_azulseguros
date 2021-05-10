package com.testeazulseguros.rest_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Cliente {
   public Cliente(String nome, String email, String cpf, String cep, String logradouro) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cep = cep;
		this.logradouro = logradouro;
	}
@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;
   private String email;
   private String cpf;
   private String cep;
   private String logradouro;      
}
