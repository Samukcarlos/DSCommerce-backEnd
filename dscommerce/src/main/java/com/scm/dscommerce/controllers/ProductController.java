package com.scm.dscommerce.controllers;

import com.scm.dscommerce.dto.ProductDTO;
import com.scm.dscommerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController // Configura para que esta classe responda na WEB
@RequestMapping(value = "/products") // rota
public class ProductController {
@Autowired // injetar componente do productRepository
    private ProductServices services;
    //@GetMapping (value = "/{id}") // respondendo pelo método GET, vizualizando no Postman (value = "/{id}") -> configurando a reto para que rota/1 retorne o produto de id 1
   //public ProductDTO findById(@PathVariable Long id){ // @PathVariable -> casando Long id com value "/{id}" configurando parametro de rota
      //ProductDTO dto = services.findByID(id);       //Optional<Product> result = repository.findById(1L); // buscando produtos no banco de dados (findById(1L) -> produto id 1 Long
       // return dto;                              // Optional<Product> result -> variável para receber o resultado da consulta ao banco de dados. (findById(1L) -> retorna por padrão Optional<>
                                                //Product product = result.get(); // .get pega o produto que está dentro do "Optional"

    @GetMapping (value = "/{id}") // Customizando retorno de código de nenhum erro no Postman
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO dto = services.findByID(id);
        return ResponseEntity.ok(dto);
    }
   // @GetMapping () // buscando todos os produtos
    //public List<ProductDTO> findALL(){ //
      //  return services.findALL();

   // @GetMapping () // buscando todos os produtos
    //public Page<ProductDTO> findALL(Pageable pegeable){ // criando Paginação
      //  return services.findALL(pegeable);

    @GetMapping () //
    public ResponseEntity<Page<ProductDTO>> findALL(Pageable pegeable){ //ResponseEntity -> assinatura do método
        Page<ProductDTO> dto = services.findALL(pegeable);
        return ResponseEntity.ok(dto);
    }
    //@PostMapping () // buscando todos os produtos
    //public ProductDTO insert(@RequestBody ProductDTO dto){ // @RequestBody -> este será p corpo da requisição
      //  dto =  services.insert(dto);
      //  return dto;

    @PostMapping ()
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
        dto =  services.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);// Devolvendo como resposta no Postman 201 ("created") e no cabessálho da resposta terá o link do recurso criado a URI
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) { // No Put tambem tenho o corpo Bary
        dto = services.update(id, dto);
        return ResponseEntity.ok(dto);
    }

}

