package com.scm.dscommerce.controllers;

import com.scm.dscommerce.dto.ProductDTO;
import com.scm.dscommerce.entities.Product;
import com.scm.dscommerce.repositories.ProductRepository;
import com.scm.dscommerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // Configura para que esta classe responda na WEB
@RequestMapping(value = "/products") // rota
public class ProductController {
@Autowired // injetar componente do productRepository
    private ProductServices services;
    @GetMapping (value = "/{id}") // respondendo pelo método GET, vizualizando no Postman (value = "/{id}") -> configurando a reto para que rota/1 retorne o produto de id 1
   public ProductDTO findById(@PathVariable Long id){ // @PathVariable -> casando Long id com value "/{id}" configurando parametro de rota
      ProductDTO dto = services.findByID(id);       //Optional<Product> result = repository.findById(1L); // buscando produtos no banco de dados (findById(1L) -> produto id 1 Long
        return dto;                              // Optional<Product> result -> variável para receber o resultado da consulta ao banco de dados. (findById(1L) -> retorna por padrão Optional<>
                                                //Product product = result.get(); // .get pega o produto que está dentro do "Optional"

   }
}


