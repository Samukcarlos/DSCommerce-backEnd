package com.scm.dscommerce.dto;

import com.scm.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {
    private Long id;
    private String nome;
    private Double price;
    private String imgUrl;

    public ProductDTO(Long id, String nome, Double price, String imgUrl) {
        this.id = id;  // this esta referenciando o atributo da classe para que não tenha ambiguidade pois o parametro tem o mesmo nome do atrubuto da classe
        this.nome = nome;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO (Product entity){ // construtor recebendo a entidade direto e copiando os dados da entidade para o DTO
        id = entity.getId(); // sem o this esta se referindo ao parametro
        nome = entity.getNome();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

        public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
