package com.scm.dscommerce.dto;

import com.scm.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
     @NotBlank(message = "Campo requerido")    // verifica se campo não é nulo, aspas e caracteres// @NotNull -> verifica se compo não é nulo
    private String nome;
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String description; // pode ser texto muito grande
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgUrl;

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
