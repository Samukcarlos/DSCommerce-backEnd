package com.scm.dscommerce.dto;

public class OrdemItemDTO() {
    private Long productid;
    private String nome;
    private Double price;
    private Interger quantity;

    public OrdemItemDTO(Long productid, String nome, Double price, Interger quantity) {
        this.productid = productid;
        this.nome = nome;
        this.price = price;
        this.quantity = quantity;
    }
    public OrdemItemDTO(OrderItem entity) {
        productid = entity.getProduct().getId;
        nome = entity.getnome();
        price = entity.getPrice();
        quantity = entity.getquantity();
    }

    public Long getProductid() {
        return productid;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrice() {
        return price;
    }

    public Interger getQuantity() {
        return quantity;
    }

    public Double getSubtotal(){
        return price*quantity;
    }
}