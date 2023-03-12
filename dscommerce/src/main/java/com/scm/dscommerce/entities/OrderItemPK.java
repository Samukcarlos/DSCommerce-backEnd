package com.scm.dscommerce.entities;

//Classe criada para gerar a chave primária composta, Relacionamento muitos para muitos com Classe de associação

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable
public class OrderItemPK {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    // em muitos para muitos a tabela do meio tem dois relacionamentos muitos para um
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItemPK(){

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

