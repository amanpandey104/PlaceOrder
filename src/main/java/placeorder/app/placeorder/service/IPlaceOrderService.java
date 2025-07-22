package placeorder.app.placeorder.service;

import org.springframework.data.domain.Page;

import placeorder.app.placeorder.dto.OrderDTO;

public interface IPlaceOrderService {
    OrderDTO placeOrder(OrderDTO dto);
    Page<OrderDTO> getAllOrders(int page, int size);
    String getOrderStatus(Long id);
    void updateOrderStatus(Long id, String status);
}
