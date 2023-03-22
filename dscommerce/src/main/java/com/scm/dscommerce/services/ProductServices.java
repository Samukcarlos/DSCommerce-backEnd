package com.scm.dscommerce.services;

import com.scm.dscommerce.dto.ProductDTO;
import com.scm.dscommerce.entities.Product;
import com.scm.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    //@Transactional(readOnly = true)
   // public List<ProductDTO> findALL(){  // findALL para buscar todos os produtos // Pageable pageable  -> paginação
      //  List<Product> result = repository.findAll(); // repository.findAll() -> vai no banco de dados e busca todos os registros da entidade Product e colocar em uma Lista result
       // return result.stream().map(x-> new ProductDTO(x)).toList() ; //convertendo Lista de produtos em ProductDTO
        // Usando lambida map(x-> new ProductDTO(x) -> para cada registro da Lista original chamo new ProductDTO recebendo x
        // Após chamar o stream para voltar para a Lista temos que chamar toList

    @Transactional(readOnly = true) // operação de consulta
    public Page<ProductDTO> findALL(Pageable pageable ){  // Pageable pageable  -> paginação
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
}
    @Transactional() // salvando no Banco de dados
    public ProductDTO insert(ProductDTO dto){  // recebendo o json e instanciando DTO

        Product entity =new Product(); // instanciando Product
        entity.setNome(dto.getNome());// copiando os dados que chegaram no DTO e salvando em "entity"
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);// savando no banco de dados e na mesma variável entity
        return new ProductDTO(entity); // reconverter para DTO e retornar no meu método

    }
}
