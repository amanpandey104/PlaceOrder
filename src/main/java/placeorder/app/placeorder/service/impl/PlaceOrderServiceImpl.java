package placeorder.app.placeorder.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import placeorder.app.placeorder.dto.OrderDTO;
import placeorder.app.placeorder.entity.OrderEntity;
import placeorder.app.placeorder.queue.OrderQueue;
import placeorder.app.placeorder.service.IOrderService;
import placeorder.app.placeorder.service.IPlaceOrderService;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceOrderServiceImpl implements IPlaceOrderService {

    private final OrderQueue orderQueue;
    private final IOrderService orderService;

    @Override
    public OrderDTO placeOrder(OrderDTO dto) {
        OrderEntity orderEntity = OrderDTO.createEntity(dto);

        OrderDTO savedOrder = orderService.saveNewOrder(orderEntity);
        orderQueue.enqueue(savedOrder.getId());
        return savedOrder; 
    }

    @Override
    public Page<OrderDTO> getAllOrders(int page, int size) {
        return orderService.fetchAllOrders(page, size);
    }

    @Override
    public String getOrderStatus(Long id) {
        return orderService.fetchOrderStatus(id);
    }

    @Override
    public void updateOrderStatus(Long id, String status) {
        orderService.updateOrderStatus(id, status);
    }

}
