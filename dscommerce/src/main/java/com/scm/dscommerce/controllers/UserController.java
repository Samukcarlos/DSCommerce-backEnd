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
@RequestMapping(value = "/users") // rota
public class ProductController {
@Autowired // injetar componente do productRepository
    private UserServices services;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping (value = "/me") // Customizando retorno de código de nenhum erro no Postman
    public ResponseEntity<UserDTO> getMe(){
        ProductDTO dto = services.getMe();
        return ResponseEntity.ok(dto);
    }
