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
public class ProductServices {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true) // pra lok de apenas leitura pois não estamos escrevendo no DB
    public ProductMinDTO findByID(Long id){ // método que recebe de argumento um id e retorna um productDTO apartir do id. (Servuces devolve DTO para o Rest)
            Product product = repository.findById(id).orElseThrow(
                    ()-> new ResourceNotFoundException ("Recurso não encontrado"));
            //findById(id) -> pegando produto no DB pelo id e guardando no "Optional"
            // pegando o produto de (Optional e salvando em product )// orElseThrow() -> tratando exceção
            return new ProductMinDTO(product); //convertendo o produto para DTO
              }
    /*@Transactional(readOnly = true)
    public List<ProductDTO> findALL(){  // findALL para buscar todos os produtos // Pageable pageable  -> paginação
    List<Product> result = repository.findAll(); // repository.findAll() -> vai no banco de dados e busca todos os registros da entidade Product e colocar em uma Lista result
    return result.stream().map(x-> new ProductDTO(x)).toList() ; //convertendo Lista de produtos em ProductDTO
    Usando lambida map(x-> new ProductDTO(x) -> para cada registro da Lista original chamo new ProductDTO recebendo x
    Após chamar o stream para voltar para a Lista temos que chamar toList*/

    @Transactional(readOnly = true) // operação de consulta
    public Page<ProductDTO> findALL(Pageable pageable ){  // Pageable pageable  -> paginação
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
}
    @Transactional() // salvando no Banco de dados
    public ProductDTO insert(ProductDTO dto){  // recebendo o json e instanciando DTO
        Product entity = new Product(); // instanciando Product
        /*entity.setNome(dto.getNome());// copiando os dados que chegaram no DTO e salvando em "entity"
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());*/
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);// savando no banco de dados e na mesma variável entity
        return new ProductDTO(entity); // reconverter para DTO e retornar no meu método
    }
    @Transactional() // Atualizando dados
    public ProductDTO update(Long id, ProductDTO dto){ //put recebendo id e corpo bory
        try {
            Product entity = repository.getReferenceById(id); // instanciando pela referenci pelo banco de dados
            // repository.getReferenceById(id) -> não vai no DB apenas é monitorado pelo JPA
            copyDtoEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS) // suporte no tratamento de Exceptions para bancos de dados que não são h2
    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e){
         throw new DatabaseException("Falha de integridade referencial");
        }

    }
    private void copyDtoEntity(ProductDTO dto, Product entity) { // metodo criado para copia de valores
        entity.setNome(dto.getNome());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

    }

}
