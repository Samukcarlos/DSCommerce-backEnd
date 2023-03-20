package com.scm.dscommerce.dto;

import com.scm.dscommerce.entities.Product;

public class ProductDTO {
    private Long id;
    private String nome;
    private String description; // pode ser texto muito grande
    private Double price;
    private String imgUrl;

    public ProductDTO (){

    }

    public ProductDTO(Long id, String nome, String description, Double price, String imgUrl) {
        this.id = id;  // this esta referenciando o atributo da classe para que não tenha ambiguidade pois o parametro tem o mesmo nome do atrubuto da classe
        this.nome = nome;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO (Product entity){ // construtor recebendo a entidade direto e copiando os dados da entidade para o DTO
        id = entity.getId(); // sem o this esta se referindo ao parametro
        nome = entity.getNome();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
