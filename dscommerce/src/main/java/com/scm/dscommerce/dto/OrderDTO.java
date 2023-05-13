package com.scm.dscommerce.dto;

public class ClientDTO(){
    private Long id;
    private Instant moment;
    private OrderStatus;

    private ClientDTO client;
    private PaymentDTO payment;

    @NotEmpty(message = "DEve ter pelo menos uma item")
    private List<OrderItemDTO> items = new ArrayList<>();

    public ClientDTO(Long id, Instant moment, OrderStatus status,ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status
        this.client = client;
        this.payment = payment;
    }
    public ClientDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        client = new ClientDTO(entity.getClient());
        payment = payment(entity.getPayment()== null)? null : new PaymentDTO(entity.getPayment());
        for (OrderItem item : entity.getItems()){
            OrderItemDTO itemDTO = new OrderItemDTO(item);
            items.add(itemDto);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public com.scm.dscommerce.dto.ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItemDTO item : items){
            sum = sum + item.getSubTotal();
        }
        return sum;
    }
}

