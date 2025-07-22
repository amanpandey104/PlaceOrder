package placeorder.app.placeorder.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import placeorder.app.placeorder.dto.OrderDTO;
import placeorder.app.placeorder.entity.OrderEntity;
import placeorder.app.placeorder.exception.OrderNotFoundException;
import placeorder.app.placeorder.repository.OrderRepository;
import placeorder.app.placeorder.service.IOrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDTO saveNewOrder(OrderEntity orderEntity) {
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return OrderDTO.valueOf(savedOrder);
    }

    @Override
    public Page<OrderDTO> fetchAllOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("orderTime").descending());
        return orderRepository.findAll(pageable).map(OrderDTO::valueOf);
    }

    @Override
    public String fetchOrderStatus(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return orderEntity.getStatus();
    }
    
    @Override
    public void updateOrderStatus(Long id, String status) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderEntity.setStatus(status);
        orderRepository.save(orderEntity);
    }

}
