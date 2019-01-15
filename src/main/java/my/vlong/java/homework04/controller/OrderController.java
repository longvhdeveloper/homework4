package my.vlong.java.homework04.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.vlong.java.homework04.dto.OrderDTO;
import my.vlong.java.homework04.dto.OrderDetailDTO;
import my.vlong.java.homework04.dto.ProductDTO;
import my.vlong.java.homework04.entity.Order;
import my.vlong.java.homework04.entity.OrderDetail;
import my.vlong.java.homework04.entity.Product;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;
import my.vlong.java.homework04.infrastructure.OrderDetailRepositoryImpl;
import my.vlong.java.homework04.infrastructure.OrderRepositoryImpl;
import my.vlong.java.homework04.infrastructure.ProductRepositoryImpl;
import my.vlong.java.homework04.mapping.OrderDetailMapping;
import my.vlong.java.homework04.mapping.OrderMapping;
import my.vlong.java.homework04.repository.IOrderDetailRepository;
import my.vlong.java.homework04.repository.IOrderRepository;
import my.vlong.java.homework04.repository.IProductRepository;

public class OrderController {

    private final IOrderRepository orderRepository;
    private final IProductRepository productRepository;
    private final IOrderDetailRepository orderDetailRepository;

    public OrderController() {
        this.orderRepository = new OrderRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        this.orderDetailRepository = new OrderDetailRepositoryImpl();
    }

    public Optional<OrderDTO> add(OrderDTO orderDTO) throws CreatedException {
        OrderDTO orderDTOAdded = null;
        try {
            Order order = OrderMapping.INSTANCE.toEntity(orderDTO);
            System.out.println(order);
            Optional<Order> orderAdded = orderRepository.add(order);
            if (orderAdded.isPresent()) {
                orderDTOAdded = OrderMapping.INSTANCE.toDTO(orderAdded.get());
            }
        } catch (CreatedException ex) {
            throw new CreatedException("Can not create order");
        }
        return Optional.ofNullable(orderDTOAdded);
    }

    public Optional<OrderDTO> update(int id, OrderDTO orderDTO) throws UpdatedException {
        OrderDTO orderDTOUpdated = null;

        try {
            Optional<Order> orderOptional = orderRepository.findByOne(id);
            if (!orderOptional.isPresent()) {
                return Optional.empty();
            }

            Order orderUpdate = OrderMapping.INSTANCE.toEntity(orderDTO);
            orderUpdate.setId(orderOptional.get().getId());

            Optional<Order> update = orderRepository.update(orderUpdate);
            if (update.isPresent()) {
                orderDTOUpdated = OrderMapping.INSTANCE.toDTO(update.get());
            }
        } catch (DataNotFoundException | UpdatedException ex) {
            throw new UpdatedException("Can not update order");
        }

        return Optional.ofNullable(orderDTOUpdated);
    }

    public boolean delete(int id) throws DeletedException {
        try {
            orderRepository.delete(id);
        } catch (DeletedException ex) {
            throw new DeletedException(("Can not delete product"));
        }
        return false;
    }

    public Optional<OrderDTO> findProduct(int id) throws DataNotFoundException {
        OrderDTO orderDTO = null;

        try {
            Optional<Order> orderOptional = orderRepository.findByOne(id);
            if (!orderOptional.isPresent()) {
                throw new DataNotFoundException(("Can not found data"));
            }

            Order order = orderOptional.get();
            orderDTO = OrderMapping.INSTANCE.toDTO(order);
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(("Can not found data"));
        }            
        return Optional.ofNullable(orderDTO);
    }

    public List<OrderDTO> findAll() throws DataNotFoundException {
        List<OrderDTO> orderDtos = new ArrayList<>();
        try {
            List<Order> orders = orderRepository.findAll();
            orderDtos = OrderMapping.INSTANCE.toDTOs(orders);
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(("Can not found data"));
        }
        return orderDtos;
    }

    public boolean addOrderDetails(List<OrderDetailDTO> orderDetailDTOs) {
        if (orderDetailDTOs.isEmpty()) {
            return false;
        }

        orderDetailDTOs.forEach((OrderDetailDTO dto) -> {
            try {
                OrderDetail orderDetail = OrderDetailMapping.INSTANCE.toEntity(dto);
                orderDetailRepository.add(orderDetail);
            } catch (CreatedException ex) {
                System.out.println("Can not add order details");
            }
        });

        return true;
    }
    
     private boolean isAddValid(OrderDTO orderDTO) {
        return true;
    }
    
    private boolean isUpdateValid(OrderDTO orderDTO) {
        return true;
    }
}
