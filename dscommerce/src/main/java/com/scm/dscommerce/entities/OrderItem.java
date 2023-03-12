package com.scm.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_order_item") // para personalizar o nome da tabelo no Banco de Dados H2
public class OrderItem {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // instanciando classe associada.
    private Integer quantity;
    private Double price;
    public OrderItem (){
    }
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order); // o construtor recebe order e product e atribui dentro do id.
        id.setProduct(product);
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);

    }
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
