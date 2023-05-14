package com.scm.dscommerce.services;

import com.scm.dscommerce.dto.ProductDTO;
import com.scm.dscommerce.entities.Product;
import com.scm.dscommerce.repositories.ProductRepository;
import com.scm.dscommerce.services.exceptions.DatabaseException;
import com.scm.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true) // operação de consulta
    public List<CategoryDTO> findALL(){  // Pageable pageable  -> paginação
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
}

