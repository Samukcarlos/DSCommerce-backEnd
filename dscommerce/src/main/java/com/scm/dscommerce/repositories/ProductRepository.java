package com.scm.dscommerce.repositories;

import com.scm.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// buscando produto no Banco de dados camada repositories
//ProductRepository responsável por operações com banco de dados de produtos
//basta fazer extends JpaRepository<Product, Long>
public interface ProductRepository extends JpaRepository<Product, Long> {
}
