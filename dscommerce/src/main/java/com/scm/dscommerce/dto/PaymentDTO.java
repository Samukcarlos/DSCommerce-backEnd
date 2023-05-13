package com.scm.dscommerce.dto;

public class PaymentDTO(){
    private Long id;
    private Instant moment;

    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }
    public PaymentDTO(Payment entity) {
        id = entity.getid;
        moment = entity.getmoment;
    }

    public Long getId() {
        return id;
    }

    public String getmoment() {
        return moment;
    }
}