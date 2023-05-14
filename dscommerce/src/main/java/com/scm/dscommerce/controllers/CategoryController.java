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
@RequestMapping(value = "/category") // rota
public class CategoryController {
    @Autowired // injetar componente do productRepository
    private CategoryServices services;
    @GetMapping //
    public ResponseEntity<List<CategoryDTO>> findALL() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}