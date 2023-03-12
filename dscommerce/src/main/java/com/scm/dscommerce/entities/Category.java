package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// Relacionamento muitos para muitos
@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_category") // para personalizar o nome da tabelo no Banco de Dados H2
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto implementação no Banco de Dados relacional
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "categories") // Relação muitos para muitos
    private Set<Product> products = new HashSet<>();// No caso de muitos para muitos para que não haja repetição
    // de id, precisamos informar isso para o JPA usando "Set" ao invés de List
    public Category(){

    }

    public Category(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
