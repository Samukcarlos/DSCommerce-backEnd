package com.scm.dscommerce.controllers;

import com.scm.dscommerce.dto.ProductDTO;
import com.scm.dscommerce.services.ProductServices;
import jakarta.validation.Valid;
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
@RequestMapping(value = "/orders") // rota
public class ProductController {
@Autowired // injetar componente do productRepository
    private OrderServices services;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping (value = "/{id}") // Customizando retorno de código de nenhum erro no Postman
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
        OrderDTO dto = services.findByID(id);
        return ResponseEntity.ok(dto);

        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
        @PostMapping
        public ResponseEntity<OrderDTO> insert(@Valid @RequestBody OrderDTO dto){ // @Valid -> Faz passar pelas verificações em ProductDTO (Campo vazio...)
            dto =  services.insert(dto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);// Devolvendo como resposta no Postman 201 ("created") e no cabessálho da resposta terá o link do recurso criado a URI
        }