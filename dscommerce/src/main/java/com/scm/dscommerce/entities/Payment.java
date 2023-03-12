package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

// A classe payment é dependente da Classe Order. relacionamento um para um.
// para que exista paymente precisa existir Order, mas para existir Order não é obrigatória a existencia de payment
@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_payment") // para criar tabela e personalizar o nome da tabelo no Banco de Dados H2
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")// para que seja salvo no banco de dados no padrão utc, depois convertemos para o horário local
    private Instant moment;

    @OneToOne //relacionamento um para um entidade dependente.
    @MapsId

    private Order order; // associando

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment(){

    }


}
