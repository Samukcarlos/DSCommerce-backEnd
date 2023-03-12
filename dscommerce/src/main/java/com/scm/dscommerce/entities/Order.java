package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_order") // para personalizar o nome da tabelo no Banco de Dados H2
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")// para que seja salvo no banco de dados no padrão utc, depois convertemos para o horário local
    private Instant moment;
    private OrderStatus status;
    @ManyToOne // mapeando muitos para um no banco de dados.
    @JoinColumn(name = "client_id") // inclui um campo na tabela orde com o nome da chave estrangeira client_id (lado do "munitos")
    private User client; // implementando relacionamento muitos para 1 (user Client)
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // relacionamento um para um
    private Payment payment; // relacionamento
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }
    public List<Product> getProducts() {
        return items.stream().map(x -> x.getProduct()).toList();

        // transforma os itens tipo items para tipo product, assim podemos pegar produtos associados
    }
    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;

    }


}


