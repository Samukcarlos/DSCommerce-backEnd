package com.scm.dscommerce.services;
@Service
public class OrderService{
    @Autowrrided
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
   private OrderItemRepository orderItemRepository;
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;
    @Transactional(readOnly = true) // pra lok de apenas leitura pois não estamos escrevendo no DB
    public OrderDTO findByID(Long id){ // método que recebe de argumento um id e retorna um productDTO apartir do id. (Servuces devolve DTO para o Rest)
        Order order = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException ("Recurso não encontrado"));
                authService.validateSelforAdmin(order.getClient().getId());
                return new OrderDTO(Order); //convertendo o produto para DTO
    }

    public OrderDTO insert(OrderDTO dto){
        Order order = new Order();

        order.setMoment(Insyant.now());
        order.setMoment(OrderStatus.WAITTING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO) itemDTO : dto.getItems()){
    Product product = productRepository.getReferenceById(itemDTO.getProductId());
    OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
    Order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }
}