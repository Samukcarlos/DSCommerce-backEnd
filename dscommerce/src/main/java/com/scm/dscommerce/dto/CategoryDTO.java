package com.scm.dscommerce.dto;

public class CategoryDTO(){
    private Long id;
    private String nome;

    public CategoryDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public CategoryDTO(Category entity) {
        id = entity.getid;
        nome = entity.getnome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}