package com.scm.dscommerce.dto;

public class ClientDTO(){
    private Long id;
    private String nome;

    public ClientDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public ClaintDTO(Category entity) {
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