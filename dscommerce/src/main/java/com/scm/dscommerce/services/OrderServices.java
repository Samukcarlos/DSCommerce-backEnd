package com.scm.dscommerce.services;
@Service
public class OrderService{
    @Autowrrided
    private OrderRepository repository;
    @Transactional(readOnly = true) // pra lok de apenas leitura pois não estamos escrevendo no DB
    public OrderDTO findByID(Long id){ // método que recebe de argumento um id e retorna um productDTO apartir do id. (Servuces devolve DTO para o Rest)
        Order order = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException ("Recurso não encontrado"));
                return new OrderDTO(Order); //convertendo o produto para DTO
    }
}