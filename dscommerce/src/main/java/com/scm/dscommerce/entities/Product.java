package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_product") // para personalizar o nome da tabelo no Banco de Dados H2

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto implementação no Banco de Dados relacional
    private Long id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String description; // pode se texto muito grande
    private Double price;
    private String imgUrl;
    @ManyToMany // relação muitos para muitos
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>(); // No caso de muitos para muitos para que não haja repetição
    // de id, precisamos informar isso para o JPA usando "Set" ao invés de List
    @OneToMany(mappedBy = "id.product") // id tem p product dentro, por isso mappeBy assim
    private Set<OrderItem> items = new HashSet<>(); // O produto pode consultar varias orderItems.
    public Product(){

    }

    public Product(Long id, String nome, String description, Double price, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Order> getOrder() {
        return items.stream().map(x -> x.getOrder()).toList();
    }


}
