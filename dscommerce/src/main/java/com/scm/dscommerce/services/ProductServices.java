package com.scm.dscommerce.services;

import com.scm.dscommerce.dto.ProductDTO;
import com.scm.dscommerce.entities.Product;
import com.scm.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true) // pra lok de apenas leitura pois não estamos escrevendo no DB
    public ProductDTO findByID(Long id){ // método que recebe de argumento um id e retorna um productDTO apartir do id. (Servuces devolve DTO para o Rest
        Optional<Product> result = repository.findById(id); // pegando prduto no DB pelo id e guardando no "Optional"
        Product product = result.get(); // pegando o produto de "Optional e salvando em product
        ProductDTO dto = new ProductDTO(product); //convertendo o produto para DTO
        return dto;

    }
}
